package srcs.chat.implem;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import srcs.chat.ChatMessage;
import srcs.chat.ChatServiceGrpc.ChatServiceImplBase;
import srcs.chat.Empty;
import srcs.chat.ListResponse;
import srcs.chat.MessageServiceGrpc;
import srcs.chat.SendRequest;
import srcs.chat.SendResponse;
import srcs.chat.SubscribeRequest;
import srcs.chat.SubscribeResponse;
import srcs.chat.UnsubscribeRequest;
import srcs.grpc.util.BuilderUtil;

public class ChatImpl extends ChatServiceImplBase{

	Map<String, InetSocketAddress> chatter = new HashMap<>();

	@Override
	public void subscribe(SubscribeRequest request, StreamObserver<SubscribeResponse> responseObserver) {
		
		String pseudo = request.getPseudo();
		// speudo deja present 
		if(this.chatter.containsKey(pseudo)) {
			SubscribeResponse response = SubscribeResponse.newBuilder().setStatus(false).build();
			
			responseObserver.onNext(response);
			responseObserver.onCompleted();
			return;
		}
		
		// pseudo inexistant
		InetSocketAddress addr = new InetSocketAddress(request.getIpHost(), request.getPort());
		synchronized(this.chatter) {
			this.chatter.put(pseudo, addr);
		}
		
		SubscribeResponse response = SubscribeResponse.newBuilder().setStatus(true).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
		return; 
		
	}

	@Override
	public void unsubscribe(UnsubscribeRequest request, StreamObserver<Empty> responseObserver) {
		
		String pseudo = request.getPseudo();
		synchronized(this.chatter) {
			this.chatter.remove(pseudo);
		}
		
		Empty responsEmpty = Empty.newBuilder().build();
		
		responseObserver.onNext(responsEmpty);
		responseObserver.onCompleted();
	}

	@Override
	public void sendMessage(SendRequest request, StreamObserver<SendResponse> responseObserver) {
		String sender = request.getPseudo();
		String message = request.getMessage();
		int count = 0;
		
		for(Map.Entry<String, InetSocketAddress> entry: this.chatter.entrySet()) {
			if(!sender.equals(entry.getKey())) {
				// Non bloquant donc on utilise un thread
				new Thread(() ->{
					try {
						InetSocketAddress addr = entry.getValue();
						//là le serveur se comporte comme un client 
						
						ManagedChannelBuilder<?> chanb = ManagedChannelBuilder.forAddress(addr.getHostName(), addr.getPort())
																			.usePlaintext();
						chanb = BuilderUtil.disableStat(chanb);
						ManagedChannel chan = chanb.build();
						
						MessageServiceGrpc.MessageServiceBlockingStub stub = MessageServiceGrpc.newBlockingStub(chan);
						ChatMessage messageRequest = ChatMessage.newBuilder().setSender(sender)
																			  .setContent(message)
																			  .build();
						stub.newMessage(messageRequest);
						chan.shutdownNow();
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}).start();
			}
			count++;
		}
		
		SendResponse response = SendResponse.newBuilder().setNbUsers(count).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	public void listChat(Empty request, StreamObserver<ListResponse> responseObserver) {
		
		ArrayList<String> chatters = new ArrayList<>(this.chatter.keySet());
		
		ListResponse response = ListResponse.newBuilder().addAllPseudos(chatters).build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
	

}

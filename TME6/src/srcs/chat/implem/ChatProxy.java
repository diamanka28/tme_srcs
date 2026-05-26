package srcs.chat.implem;

import java.io.IOException;
import java.util.List;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import srcs.chat.ChatMessage;
import srcs.chat.ChatServiceGrpc;
import srcs.chat.Empty;
import srcs.chat.ListResponse;
import srcs.chat.MessageServiceGrpc.MessageServiceImplBase;
import srcs.chat.SendRequest;
import srcs.chat.SendResponse;
import srcs.chat.SubscribeRequest;
import srcs.chat.SubscribeResponse;
import srcs.chat.UnsubscribeRequest;
import srcs.grpc.util.BuilderUtil;

public class ChatProxy implements Chat{

	private final String host;
	private final int port;
	private MessageReceiver messagerReceived;
	
	private ManagedChannel channel;
	private ChatServiceGrpc.ChatServiceBlockingStub messagerie ;
	private int portback;
	private Server receiver;
	
	public ChatProxy(String host, int port, MessageReceiver mess) {
		this.host = host;
		this.port = port;
		this.messagerReceived = mess;
		
		ManagedChannelBuilder<?> chanb = ManagedChannelBuilder.forAddress(host, port)
															  .usePlaintext();
		chanb = BuilderUtil.disableStat(chanb);
		this.channel = chanb.build();
		
		this.messagerie = ChatServiceGrpc.newBlockingStub(this.channel);
	}
	
	@Override
	public boolean subscribe(String pseudo, String host, int port) {
		//port retour
		this.portback = port; 
		
		SubscribeRequest resquest = SubscribeRequest.newBuilder().setIpHost(host)
																.setPort(port)
																.setPseudo(pseudo)
																.build();
		SubscribeResponse response = this.messagerie.subscribe(resquest);
		
		if(response.getStatus() && this.receiver == null) {
			this.callback();
		}
		
		return response.getStatus();
	}

	@Override
	public int send(String pseudo, String message) {
		
		SendRequest request = SendRequest.newBuilder().setMessage(message)
													   .setPseudo(pseudo)
													   .build();
		SendResponse response = this.messagerie.sendMessage(request);
		
		return response.getNbUsers();
	}

	@Override
	public List<String> listChatter() {
		ListResponse response = this.messagerie.listChat(Empty.getDefaultInstance());
		
		return response.getPseudosList();
	}

	public void callback() {
		ServerBuilder<?> servB = ServerBuilder.forPort(this.portback).addService(new MessageServiceImplBase() {
			@Override
			public void newMessage(ChatMessage request, StreamObserver<Empty> responseObserver) {
				messagerReceived.newMessage(request.getSender(), request.getContent());
				
				responseObserver.onNext(Empty.getDefaultInstance());
				responseObserver.onCompleted();
			}
		});
		
		servB = BuilderUtil.disableStat(servB);
		this.receiver = servB.build();
		try {
			this.receiver.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void unsubscribe(String pseudo) {
		
		UnsubscribeRequest request = UnsubscribeRequest.newBuilder().setPseudo(pseudo).build();
		
		this.messagerie.unsubscribe(request);
		
		if(this.receiver != null) {
			this.receiver.shutdownNow();
			this.receiver = null;
		}
	
	}

}

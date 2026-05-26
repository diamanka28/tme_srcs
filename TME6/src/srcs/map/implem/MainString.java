package srcs.map.implem;

import java.io.IOException;

import org.junit.runner.Request;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.StringValue;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.testing.integration.EmptyProtos.Empty;
import srcs.grpc.util.BuilderUtil;
import srcs.map.EntryString;
import srcs.map.MapStringRemoteGrpc;
import srcs.map.MapStringRemoteGrpc.MapStringRemoteBlockingStub;
import srcs.map.MapStringRemoteGrpc.MapStringRemoteFutureStub;

public class MainString {

	static final int port=1234;
	
	public static void main(String[] args) throws Exception{
		
		// deployer le serveur (peut etre fait dans un autre main)
		ServerBuilder<?> serverbuilder = ServerBuilder.forPort(port).addService(new MapStringRemoteImplem());
		serverbuilder = BuilderUtil.disableStat(serverbuilder);
		Server server = serverbuilder.build();
		server.start();
		Thread.sleep(300);
		
		//code client
		ManagedChannelBuilder<?> chanbuilder = ManagedChannelBuilder.forAddress("localhost", port)
																	.usePlaintext();
		chanbuilder=BuilderUtil.disableStat(chanbuilder);
		ManagedChannel chan = chanbuilder.build();
		
		String key="toto";
		String value="valtoto";
		EntryString request = EntryString.newBuilder().setKey(key).setValue(value).build();
		
		//version synchrone
//		MapStringRemoteBlockingStub map = MapStringRemoteGrpc.newBlockingStub(chan);
//		
//		map.put(request);
//		String res = map.get(StringValue.of(key)).getValue();
//		
		//Semi-synchrone
		MapStringRemoteFutureStub map = MapStringRemoteGrpc.newFutureStub(chan);
		ListenableFuture<com.google.protobuf.Empty> retour = map.put(request);
		ListenableFuture<StringValue> retour2 = map.get(StringValue.of(key));
		
		String res = retour2.get().getValue(); //il récupere rien ici
		
		for(int i=0; i<10; i++) {
		 //ici je fais ce que je veux en attendant
			Thread.sleep(30);
			//Thread.yield();
		}
		retour.get();
		res = retour2.get().getValue(); //là il le recupere 
		
		System.out.println("helloworld: " +res);
	}
}

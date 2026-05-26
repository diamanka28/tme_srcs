package srcs.inventory.implem;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import srcs.grpc.util.BuilderUtil;

public class InventoryServer {

	public static void main(String[] args) throws Exception{
		ServerBuilder<?> serverb =  ServerBuilder.forPort(5000)
						.addService(new InventoryImplem());
		serverb = BuilderUtil.disableStat(serverb);
		
		Server server = serverb.build();
		server.start();
		
		server.awaitTermination();
		
	}
}

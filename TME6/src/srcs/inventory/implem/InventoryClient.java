package srcs.inventory.implem;

import java.util.Iterator;

import com.google.protobuf.StringValue;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import srcs.grpc.util.BuilderUtil;
import srcs.inventory.InventoryServiceGrpc;
import srcs.inventory.InventoryServiceGrpc.InventoryServiceBlockingStub;
import srcs.inventory.Product;
import srcs.inventory.StockChange;

public class InventoryClient {

	public static void main(String[] args) throws Exception{
		
		ManagedChannelBuilder<?> chanb = ManagedChannelBuilder.forAddress("localhost", 5000)
													.usePlaintext();
		
		chanb = BuilderUtil.disableStat(chanb);
		ManagedChannel chan = chanb.build();
		
		// Stub bloquant
		InventoryServiceBlockingStub stub = InventoryServiceGrpc.newBlockingStub(chan);
		System.out.println("----Catalogue-------");
		Iterator<Product> produits = stub.listProduct(null);
		while(produits.hasNext()) {
			Product  p = produits.next();
			System.out.println(p.getNom() + " | Stock: " + p.getQuantite()+ " | Prix: " + p.getPrix());
		}
		
		System.out.println("------vente de deux claviers----------");
		StockChange stock = StockChange.newBuilder().setId("P1").setChange(-2).build();
		Product upProd = stub.updateStock(stock);
		System.out.println("Nouveau stock pour " + upProd.getNom() + " : " + upProd.getQuantite());
		
		System.out.println("-------Rapport avec les Chargeurs--------");
		Product p = stub.getProduct(StringValue.of("P3"));
		System.out.println(p.getNom() + " | Stock: " + p.getQuantite() + " | Prix: " + p.getPrix());
		
		chan.shutdown();
	}
}

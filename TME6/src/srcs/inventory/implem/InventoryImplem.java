package srcs.inventory.implem;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.protobuf.Empty;
import com.google.protobuf.StringValue;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import srcs.inventory.InventoryServiceGrpc.InventoryServiceImplBase;
import srcs.inventory.Product;
import srcs.inventory.StockChange;

public class InventoryImplem extends InventoryServiceImplBase{
	
	private Map<String, Product> produits;
	
	public InventoryImplem() {
		this.produits = new HashMap<>();
		//on ajoute deux produits
		produits.put("P1", Product.newBuilder().setId("P1").setNom("Clavier").setQuantite(10).setPrix(49.99).build());
        produits.put("P2", Product.newBuilder().setId("P2").setNom("Souris").setQuantite(25).setPrix(19.99).build());
		produits.put("P3", Product.newBuilder().setId("P3").setNom("Chargeur").setQuantite(22).setPrix(200).build());

	}
	
	@Override
	public synchronized void getProduct(StringValue request, StreamObserver<Product> responseObserver) {
		String tmp = request.getValue();
		
		Product prod = this.produits.get(tmp);
		if(prod != null) {
			responseObserver.onNext(prod);
			responseObserver.onCompleted();
		}
		else {
			// On construit une erreur propre avec un code NOT_FOUND
	        Status status = Status.NOT_FOUND
	                        .withDescription("Le produit avec l'ID " + request.getValue() + " n'existe pas.");
	        
	        responseObserver.onError(status.asRuntimeException());
	        return; 
		}
	}

	@Override
	public synchronized void listProduct(Empty request, StreamObserver<Product> responseObserver) {
		ArrayList<Product> prods = new ArrayList<Product>(this.produits.values());
		
		for(Product send : prods) {
			responseObserver.onNext(send);
		}
		responseObserver.onCompleted();
	}

	@Override
	public synchronized void updateStock(StockChange request, StreamObserver<Product> responseObserver) {
		Product existProd = this.produits.get(request.getId());
		if(existProd != null) {
			Product upProd = Product.newBuilder(existProd)
							.setQuantite(request.getChange() + existProd.getQuantite())
							.build();
			this.produits.put(request.getId(), upProd);
			responseObserver.onNext(upProd);
			responseObserver.onCompleted();
		}
		else {
			Status status = Status.NOT_FOUND.withDescription("Ce produit n'existe pas!");
			responseObserver.onError(status.asRuntimeException());
			
			return;
		}
	}

	
}

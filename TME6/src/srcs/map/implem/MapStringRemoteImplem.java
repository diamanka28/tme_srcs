package srcs.map.implem;

import java.util.HashMap;
import java.util.Map;

import com.google.protobuf.Empty;
import com.google.protobuf.StringValue;

import io.grpc.stub.StreamObserver;
import srcs.map.EntryString;
import srcs.map.MapStringRemoteGrpc.MapStringRemoteImplBase;

//coté serveur
public class MapStringRemoteImplem extends MapStringRemoteImplBase {

	private Map<String, String> map = new HashMap<>();

	@Override
	public void get(StringValue request, StreamObserver<StringValue> responseObserver) {
		String tmp = request.getValue();
		String res;
		synchronized(this.map) {
			res = map.getOrDefault(tmp, "");
		}
		responseObserver.onNext(StringValue.of(res));//la prochaine valeur à envoyer
		responseObserver.onCompleted(); // envoyer la valeur
	} 

	@Override
	public void put(EntryString request, StreamObserver<Empty> responseObserver) {

		String key = request.getKey();
		String value = request.getValue();
		synchronized(this.map) {
			map.put(key, value);
		}
		responseObserver.onNext(Empty.getDefaultInstance());
		responseObserver.onCompleted();
	}
	
}

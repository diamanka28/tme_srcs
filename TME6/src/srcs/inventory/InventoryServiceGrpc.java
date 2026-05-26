package srcs.inventory;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0)",
    comments = "Source: inventory.proto")
public final class InventoryServiceGrpc {

  private InventoryServiceGrpc() {}

  public static final String SERVICE_NAME = "srcs.inventory.InventoryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      srcs.inventory.Product> getGetProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProduct",
      requestType = com.google.protobuf.StringValue.class,
      responseType = srcs.inventory.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue,
      srcs.inventory.Product> getGetProductMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.StringValue, srcs.inventory.Product> getGetProductMethod;
    if ((getGetProductMethod = InventoryServiceGrpc.getGetProductMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getGetProductMethod = InventoryServiceGrpc.getGetProductMethod) == null) {
          InventoryServiceGrpc.getGetProductMethod = getGetProductMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, srcs.inventory.Product>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.StringValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.inventory.Product.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("getProduct"))
              .build();
        }
      }
    }
    return getGetProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      srcs.inventory.Product> getListProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listProduct",
      requestType = com.google.protobuf.Empty.class,
      responseType = srcs.inventory.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      srcs.inventory.Product> getListProductMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, srcs.inventory.Product> getListProductMethod;
    if ((getListProductMethod = InventoryServiceGrpc.getListProductMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getListProductMethod = InventoryServiceGrpc.getListProductMethod) == null) {
          InventoryServiceGrpc.getListProductMethod = getListProductMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, srcs.inventory.Product>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.inventory.Product.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("listProduct"))
              .build();
        }
      }
    }
    return getListProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<srcs.inventory.StockChange,
      srcs.inventory.Product> getUpdateStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateStock",
      requestType = srcs.inventory.StockChange.class,
      responseType = srcs.inventory.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<srcs.inventory.StockChange,
      srcs.inventory.Product> getUpdateStockMethod() {
    io.grpc.MethodDescriptor<srcs.inventory.StockChange, srcs.inventory.Product> getUpdateStockMethod;
    if ((getUpdateStockMethod = InventoryServiceGrpc.getUpdateStockMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getUpdateStockMethod = InventoryServiceGrpc.getUpdateStockMethod) == null) {
          InventoryServiceGrpc.getUpdateStockMethod = getUpdateStockMethod =
              io.grpc.MethodDescriptor.<srcs.inventory.StockChange, srcs.inventory.Product>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.inventory.StockChange.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.inventory.Product.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("updateStock"))
              .build();
        }
      }
    }
    return getUpdateStockMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InventoryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceStub>() {
        @java.lang.Override
        public InventoryServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceStub(channel, callOptions);
        }
      };
    return InventoryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InventoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceBlockingStub>() {
        @java.lang.Override
        public InventoryServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceBlockingStub(channel, callOptions);
        }
      };
    return InventoryServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InventoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceFutureStub>() {
        @java.lang.Override
        public InventoryServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceFutureStub(channel, callOptions);
        }
      };
    return InventoryServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class InventoryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getProduct(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<srcs.inventory.Product> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProductMethod(), responseObserver);
    }

    /**
     */
    public void listProduct(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<srcs.inventory.Product> responseObserver) {
      asyncUnimplementedUnaryCall(getListProductMethod(), responseObserver);
    }

    /**
     */
    public void updateStock(srcs.inventory.StockChange request,
        io.grpc.stub.StreamObserver<srcs.inventory.Product> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateStockMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetProductMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.StringValue,
                srcs.inventory.Product>(
                  this, METHODID_GET_PRODUCT)))
          .addMethod(
            getListProductMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                srcs.inventory.Product>(
                  this, METHODID_LIST_PRODUCT)))
          .addMethod(
            getUpdateStockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                srcs.inventory.StockChange,
                srcs.inventory.Product>(
                  this, METHODID_UPDATE_STOCK)))
          .build();
    }
  }

  /**
   */
  public static final class InventoryServiceStub extends io.grpc.stub.AbstractAsyncStub<InventoryServiceStub> {
    private InventoryServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceStub(channel, callOptions);
    }

    /**
     */
    public void getProduct(com.google.protobuf.StringValue request,
        io.grpc.stub.StreamObserver<srcs.inventory.Product> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listProduct(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<srcs.inventory.Product> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateStock(srcs.inventory.StockChange request,
        io.grpc.stub.StreamObserver<srcs.inventory.Product> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateStockMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class InventoryServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<InventoryServiceBlockingStub> {
    private InventoryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public srcs.inventory.Product getProduct(com.google.protobuf.StringValue request) {
      return blockingUnaryCall(
          getChannel(), getGetProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<srcs.inventory.Product> listProduct(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getListProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public srcs.inventory.Product updateStock(srcs.inventory.StockChange request) {
      return blockingUnaryCall(
          getChannel(), getUpdateStockMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class InventoryServiceFutureStub extends io.grpc.stub.AbstractFutureStub<InventoryServiceFutureStub> {
    private InventoryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<srcs.inventory.Product> getProduct(
        com.google.protobuf.StringValue request) {
      return futureUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<srcs.inventory.Product> updateStock(
        srcs.inventory.StockChange request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateStockMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PRODUCT = 0;
  private static final int METHODID_LIST_PRODUCT = 1;
  private static final int METHODID_UPDATE_STOCK = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final InventoryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(InventoryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PRODUCT:
          serviceImpl.getProduct((com.google.protobuf.StringValue) request,
              (io.grpc.stub.StreamObserver<srcs.inventory.Product>) responseObserver);
          break;
        case METHODID_LIST_PRODUCT:
          serviceImpl.listProduct((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<srcs.inventory.Product>) responseObserver);
          break;
        case METHODID_UPDATE_STOCK:
          serviceImpl.updateStock((srcs.inventory.StockChange) request,
              (io.grpc.stub.StreamObserver<srcs.inventory.Product>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class InventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InventoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return srcs.inventory.Inventory.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InventoryService");
    }
  }

  private static final class InventoryServiceFileDescriptorSupplier
      extends InventoryServiceBaseDescriptorSupplier {
    InventoryServiceFileDescriptorSupplier() {}
  }

  private static final class InventoryServiceMethodDescriptorSupplier
      extends InventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    InventoryServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (InventoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InventoryServiceFileDescriptorSupplier())
              .addMethod(getGetProductMethod())
              .addMethod(getListProductMethod())
              .addMethod(getUpdateStockMethod())
              .build();
        }
      }
    }
    return result;
  }
}

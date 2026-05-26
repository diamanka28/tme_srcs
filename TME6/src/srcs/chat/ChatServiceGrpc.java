package srcs.chat;

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
 * <pre>
 *service du serveur
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.26.0)",
    comments = "Source: chatRemote.proto")
public final class ChatServiceGrpc {

  private ChatServiceGrpc() {}

  public static final String SERVICE_NAME = "srcs.chat.ChatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<srcs.chat.SubscribeRequest,
      srcs.chat.SubscribeResponse> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = srcs.chat.SubscribeRequest.class,
      responseType = srcs.chat.SubscribeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<srcs.chat.SubscribeRequest,
      srcs.chat.SubscribeResponse> getSubscribeMethod() {
    io.grpc.MethodDescriptor<srcs.chat.SubscribeRequest, srcs.chat.SubscribeResponse> getSubscribeMethod;
    if ((getSubscribeMethod = ChatServiceGrpc.getSubscribeMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getSubscribeMethod = ChatServiceGrpc.getSubscribeMethod) == null) {
          ChatServiceGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<srcs.chat.SubscribeRequest, srcs.chat.SubscribeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.chat.SubscribeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.chat.SubscribeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<srcs.chat.UnsubscribeRequest,
      srcs.chat.Empty> getUnsubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "unsubscribe",
      requestType = srcs.chat.UnsubscribeRequest.class,
      responseType = srcs.chat.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<srcs.chat.UnsubscribeRequest,
      srcs.chat.Empty> getUnsubscribeMethod() {
    io.grpc.MethodDescriptor<srcs.chat.UnsubscribeRequest, srcs.chat.Empty> getUnsubscribeMethod;
    if ((getUnsubscribeMethod = ChatServiceGrpc.getUnsubscribeMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getUnsubscribeMethod = ChatServiceGrpc.getUnsubscribeMethod) == null) {
          ChatServiceGrpc.getUnsubscribeMethod = getUnsubscribeMethod =
              io.grpc.MethodDescriptor.<srcs.chat.UnsubscribeRequest, srcs.chat.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "unsubscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.chat.UnsubscribeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.chat.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("unsubscribe"))
              .build();
        }
      }
    }
    return getUnsubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<srcs.chat.SendRequest,
      srcs.chat.SendResponse> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMessage",
      requestType = srcs.chat.SendRequest.class,
      responseType = srcs.chat.SendResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<srcs.chat.SendRequest,
      srcs.chat.SendResponse> getSendMessageMethod() {
    io.grpc.MethodDescriptor<srcs.chat.SendRequest, srcs.chat.SendResponse> getSendMessageMethod;
    if ((getSendMessageMethod = ChatServiceGrpc.getSendMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getSendMessageMethod = ChatServiceGrpc.getSendMessageMethod) == null) {
          ChatServiceGrpc.getSendMessageMethod = getSendMessageMethod =
              io.grpc.MethodDescriptor.<srcs.chat.SendRequest, srcs.chat.SendResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.chat.SendRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.chat.SendResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("sendMessage"))
              .build();
        }
      }
    }
    return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<srcs.chat.Empty,
      srcs.chat.ListResponse> getListChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listChat",
      requestType = srcs.chat.Empty.class,
      responseType = srcs.chat.ListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<srcs.chat.Empty,
      srcs.chat.ListResponse> getListChatMethod() {
    io.grpc.MethodDescriptor<srcs.chat.Empty, srcs.chat.ListResponse> getListChatMethod;
    if ((getListChatMethod = ChatServiceGrpc.getListChatMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getListChatMethod = ChatServiceGrpc.getListChatMethod) == null) {
          ChatServiceGrpc.getListChatMethod = getListChatMethod =
              io.grpc.MethodDescriptor.<srcs.chat.Empty, srcs.chat.ListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "listChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.chat.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  srcs.chat.ListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("listChat"))
              .build();
        }
      }
    }
    return getListChatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatServiceStub>() {
        @java.lang.Override
        public ChatServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatServiceStub(channel, callOptions);
        }
      };
    return ChatServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatServiceBlockingStub>() {
        @java.lang.Override
        public ChatServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatServiceBlockingStub(channel, callOptions);
        }
      };
    return ChatServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatServiceFutureStub>() {
        @java.lang.Override
        public ChatServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatServiceFutureStub(channel, callOptions);
        }
      };
    return ChatServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *service du serveur
   * </pre>
   */
  public static abstract class ChatServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void subscribe(srcs.chat.SubscribeRequest request,
        io.grpc.stub.StreamObserver<srcs.chat.SubscribeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }

    /**
     */
    public void unsubscribe(srcs.chat.UnsubscribeRequest request,
        io.grpc.stub.StreamObserver<srcs.chat.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getUnsubscribeMethod(), responseObserver);
    }

    /**
     */
    public void sendMessage(srcs.chat.SendRequest request,
        io.grpc.stub.StreamObserver<srcs.chat.SendResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    /**
     */
    public void listChat(srcs.chat.Empty request,
        io.grpc.stub.StreamObserver<srcs.chat.ListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListChatMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubscribeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                srcs.chat.SubscribeRequest,
                srcs.chat.SubscribeResponse>(
                  this, METHODID_SUBSCRIBE)))
          .addMethod(
            getUnsubscribeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                srcs.chat.UnsubscribeRequest,
                srcs.chat.Empty>(
                  this, METHODID_UNSUBSCRIBE)))
          .addMethod(
            getSendMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                srcs.chat.SendRequest,
                srcs.chat.SendResponse>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getListChatMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                srcs.chat.Empty,
                srcs.chat.ListResponse>(
                  this, METHODID_LIST_CHAT)))
          .build();
    }
  }

  /**
   * <pre>
   *service du serveur
   * </pre>
   */
  public static final class ChatServiceStub extends io.grpc.stub.AbstractAsyncStub<ChatServiceStub> {
    private ChatServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatServiceStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(srcs.chat.SubscribeRequest request,
        io.grpc.stub.StreamObserver<srcs.chat.SubscribeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unsubscribe(srcs.chat.UnsubscribeRequest request,
        io.grpc.stub.StreamObserver<srcs.chat.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnsubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessage(srcs.chat.SendRequest request,
        io.grpc.stub.StreamObserver<srcs.chat.SendResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listChat(srcs.chat.Empty request,
        io.grpc.stub.StreamObserver<srcs.chat.ListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListChatMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *service du serveur
   * </pre>
   */
  public static final class ChatServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ChatServiceBlockingStub> {
    private ChatServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public srcs.chat.SubscribeResponse subscribe(srcs.chat.SubscribeRequest request) {
      return blockingUnaryCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public srcs.chat.Empty unsubscribe(srcs.chat.UnsubscribeRequest request) {
      return blockingUnaryCall(
          getChannel(), getUnsubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public srcs.chat.SendResponse sendMessage(srcs.chat.SendRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public srcs.chat.ListResponse listChat(srcs.chat.Empty request) {
      return blockingUnaryCall(
          getChannel(), getListChatMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *service du serveur
   * </pre>
   */
  public static final class ChatServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ChatServiceFutureStub> {
    private ChatServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<srcs.chat.SubscribeResponse> subscribe(
        srcs.chat.SubscribeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<srcs.chat.Empty> unsubscribe(
        srcs.chat.UnsubscribeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUnsubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<srcs.chat.SendResponse> sendMessage(
        srcs.chat.SendRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<srcs.chat.ListResponse> listChat(
        srcs.chat.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getListChatMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBSCRIBE = 0;
  private static final int METHODID_UNSUBSCRIBE = 1;
  private static final int METHODID_SEND_MESSAGE = 2;
  private static final int METHODID_LIST_CHAT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((srcs.chat.SubscribeRequest) request,
              (io.grpc.stub.StreamObserver<srcs.chat.SubscribeResponse>) responseObserver);
          break;
        case METHODID_UNSUBSCRIBE:
          serviceImpl.unsubscribe((srcs.chat.UnsubscribeRequest) request,
              (io.grpc.stub.StreamObserver<srcs.chat.Empty>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((srcs.chat.SendRequest) request,
              (io.grpc.stub.StreamObserver<srcs.chat.SendResponse>) responseObserver);
          break;
        case METHODID_LIST_CHAT:
          serviceImpl.listChat((srcs.chat.Empty) request,
              (io.grpc.stub.StreamObserver<srcs.chat.ListResponse>) responseObserver);
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

  private static abstract class ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return srcs.chat.ChatRemote.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChatService");
    }
  }

  private static final class ChatServiceFileDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier {
    ChatServiceFileDescriptorSupplier() {}
  }

  private static final class ChatServiceMethodDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ChatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatServiceFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .addMethod(getUnsubscribeMethod())
              .addMethod(getSendMessageMethod())
              .addMethod(getListChatMethod())
              .build();
        }
      }
    }
    return result;
  }
}

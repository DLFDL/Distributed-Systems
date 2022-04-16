package airConditionControl;

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
 * the air condition control service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: airConditionControl.proto")
public final class airConditionControlGrpc {

  private airConditionControlGrpc() {}

  public static final String SERVICE_NAME = "airConditionControl.airConditionControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<airConditionControl.LoginRequest,
      airConditionControl.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = airConditionControl.LoginRequest.class,
      responseType = airConditionControl.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<airConditionControl.LoginRequest,
      airConditionControl.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<airConditionControl.LoginRequest, airConditionControl.LoginResponse> getLoginMethod;
    if ((getLoginMethod = airConditionControlGrpc.getLoginMethod) == null) {
      synchronized (airConditionControlGrpc.class) {
        if ((getLoginMethod = airConditionControlGrpc.getLoginMethod) == null) {
          airConditionControlGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<airConditionControl.LoginRequest, airConditionControl.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "airConditionControl.airConditionControl", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  airConditionControl.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  airConditionControl.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new airConditionControlMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<airConditionControl.UpdateRequest,
      airConditionControl.UpdateResponse> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "update",
      requestType = airConditionControl.UpdateRequest.class,
      responseType = airConditionControl.UpdateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<airConditionControl.UpdateRequest,
      airConditionControl.UpdateResponse> getUpdateMethod() {
    io.grpc.MethodDescriptor<airConditionControl.UpdateRequest, airConditionControl.UpdateResponse> getUpdateMethod;
    if ((getUpdateMethod = airConditionControlGrpc.getUpdateMethod) == null) {
      synchronized (airConditionControlGrpc.class) {
        if ((getUpdateMethod = airConditionControlGrpc.getUpdateMethod) == null) {
          airConditionControlGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<airConditionControl.UpdateRequest, airConditionControl.UpdateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "airConditionControl.airConditionControl", "update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  airConditionControl.UpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  airConditionControl.UpdateResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new airConditionControlMethodDescriptorSupplier("update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<airConditionControl.LogoutRequest,
      airConditionControl.LogoutResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logout",
      requestType = airConditionControl.LogoutRequest.class,
      responseType = airConditionControl.LogoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<airConditionControl.LogoutRequest,
      airConditionControl.LogoutResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<airConditionControl.LogoutRequest, airConditionControl.LogoutResponse> getLogoutMethod;
    if ((getLogoutMethod = airConditionControlGrpc.getLogoutMethod) == null) {
      synchronized (airConditionControlGrpc.class) {
        if ((getLogoutMethod = airConditionControlGrpc.getLogoutMethod) == null) {
          airConditionControlGrpc.getLogoutMethod = getLogoutMethod = 
              io.grpc.MethodDescriptor.<airConditionControl.LogoutRequest, airConditionControl.LogoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "airConditionControl.airConditionControl", "logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  airConditionControl.LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  airConditionControl.LogoutResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new airConditionControlMethodDescriptorSupplier("logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static airConditionControlStub newStub(io.grpc.Channel channel) {
    return new airConditionControlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static airConditionControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new airConditionControlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static airConditionControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new airConditionControlFutureStub(channel);
  }

  /**
   * <pre>
   * the air condition control service definition
   * </pre>
   */
  public static abstract class airConditionControlImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public void login(airConditionControl.LoginRequest request,
        io.grpc.stub.StreamObserver<airConditionControl.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     * <pre>
     * bidirectional streaming remote procedure calls
     * user will send stream of messages to server and server will respond with stream of messages to the user
     * </pre>
     */
    public io.grpc.stub.StreamObserver<airConditionControl.UpdateRequest> update(
        io.grpc.stub.StreamObserver<airConditionControl.UpdateResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getUpdateMethod(), responseObserver);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public void logout(airConditionControl.LogoutRequest request,
        io.grpc.stub.StreamObserver<airConditionControl.LogoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                airConditionControl.LoginRequest,
                airConditionControl.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getUpdateMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                airConditionControl.UpdateRequest,
                airConditionControl.UpdateResponse>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                airConditionControl.LogoutRequest,
                airConditionControl.LogoutResponse>(
                  this, METHODID_LOGOUT)))
          .build();
    }
  }

  /**
   * <pre>
   * the air condition control service definition
   * </pre>
   */
  public static final class airConditionControlStub extends io.grpc.stub.AbstractStub<airConditionControlStub> {
    private airConditionControlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private airConditionControlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected airConditionControlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new airConditionControlStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public void login(airConditionControl.LoginRequest request,
        io.grpc.stub.StreamObserver<airConditionControl.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * bidirectional streaming remote procedure calls
     * user will send stream of messages to server and server will respond with stream of messages to the user
     * </pre>
     */
    public io.grpc.stub.StreamObserver<airConditionControl.UpdateRequest> update(
        io.grpc.stub.StreamObserver<airConditionControl.UpdateResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public void logout(airConditionControl.LogoutRequest request,
        io.grpc.stub.StreamObserver<airConditionControl.LogoutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * the air condition control service definition
   * </pre>
   */
  public static final class airConditionControlBlockingStub extends io.grpc.stub.AbstractStub<airConditionControlBlockingStub> {
    private airConditionControlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private airConditionControlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected airConditionControlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new airConditionControlBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public airConditionControl.LoginResponse login(airConditionControl.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public airConditionControl.LogoutResponse logout(airConditionControl.LogoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * the air condition control service definition
   * </pre>
   */
  public static final class airConditionControlFutureStub extends io.grpc.stub.AbstractStub<airConditionControlFutureStub> {
    private airConditionControlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private airConditionControlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected airConditionControlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new airConditionControlFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<airConditionControl.LoginResponse> login(
        airConditionControl.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<airConditionControl.LogoutResponse> logout(
        airConditionControl.LogoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_LOGOUT = 1;
  private static final int METHODID_UPDATE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final airConditionControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(airConditionControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((airConditionControl.LoginRequest) request,
              (io.grpc.stub.StreamObserver<airConditionControl.LoginResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((airConditionControl.LogoutRequest) request,
              (io.grpc.stub.StreamObserver<airConditionControl.LogoutResponse>) responseObserver);
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
        case METHODID_UPDATE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.update(
              (io.grpc.stub.StreamObserver<airConditionControl.UpdateResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class airConditionControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    airConditionControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return airConditionControl.airConditionControlImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("airConditionControl");
    }
  }

  private static final class airConditionControlFileDescriptorSupplier
      extends airConditionControlBaseDescriptorSupplier {
    airConditionControlFileDescriptorSupplier() {}
  }

  private static final class airConditionControlMethodDescriptorSupplier
      extends airConditionControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    airConditionControlMethodDescriptorSupplier(String methodName) {
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
      synchronized (airConditionControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new airConditionControlFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getUpdateMethod())
              .addMethod(getLogoutMethod())
              .build();
        }
      }
    }
    return result;
  }
}

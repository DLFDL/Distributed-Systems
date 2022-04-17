package accessControl;

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
 * the access control service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: accessControl.proto")
public final class accessControlGrpc {

  private accessControlGrpc() {}

  public static final String SERVICE_NAME = "accessControl.accessControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<accessControl.LoginRequest,
      accessControl.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = accessControl.LoginRequest.class,
      responseType = accessControl.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<accessControl.LoginRequest,
      accessControl.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<accessControl.LoginRequest, accessControl.LoginResponse> getLoginMethod;
    if ((getLoginMethod = accessControlGrpc.getLoginMethod) == null) {
      synchronized (accessControlGrpc.class) {
        if ((getLoginMethod = accessControlGrpc.getLoginMethod) == null) {
          accessControlGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<accessControl.LoginRequest, accessControl.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "accessControl.accessControl", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accessControl.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accessControl.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new accessControlMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<accessControl.AuthorizationRequest,
      accessControl.AuthorizationResponse> getAuthorizationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "authorization",
      requestType = accessControl.AuthorizationRequest.class,
      responseType = accessControl.AuthorizationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<accessControl.AuthorizationRequest,
      accessControl.AuthorizationResponse> getAuthorizationMethod() {
    io.grpc.MethodDescriptor<accessControl.AuthorizationRequest, accessControl.AuthorizationResponse> getAuthorizationMethod;
    if ((getAuthorizationMethod = accessControlGrpc.getAuthorizationMethod) == null) {
      synchronized (accessControlGrpc.class) {
        if ((getAuthorizationMethod = accessControlGrpc.getAuthorizationMethod) == null) {
          accessControlGrpc.getAuthorizationMethod = getAuthorizationMethod = 
              io.grpc.MethodDescriptor.<accessControl.AuthorizationRequest, accessControl.AuthorizationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "accessControl.accessControl", "authorization"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accessControl.AuthorizationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accessControl.AuthorizationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new accessControlMethodDescriptorSupplier("authorization"))
                  .build();
          }
        }
     }
     return getAuthorizationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<accessControl.LogoutRequest,
      accessControl.LogoutResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logout",
      requestType = accessControl.LogoutRequest.class,
      responseType = accessControl.LogoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<accessControl.LogoutRequest,
      accessControl.LogoutResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<accessControl.LogoutRequest, accessControl.LogoutResponse> getLogoutMethod;
    if ((getLogoutMethod = accessControlGrpc.getLogoutMethod) == null) {
      synchronized (accessControlGrpc.class) {
        if ((getLogoutMethod = accessControlGrpc.getLogoutMethod) == null) {
          accessControlGrpc.getLogoutMethod = getLogoutMethod = 
              io.grpc.MethodDescriptor.<accessControl.LogoutRequest, accessControl.LogoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "accessControl.accessControl", "logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accessControl.LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accessControl.LogoutResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new accessControlMethodDescriptorSupplier("logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static accessControlStub newStub(io.grpc.Channel channel) {
    return new accessControlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static accessControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new accessControlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static accessControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new accessControlFutureStub(channel);
  }

  /**
   * <pre>
   * the access control service definition
   * </pre>
   */
  public static abstract class accessControlImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public void login(accessControl.LoginRequest request,
        io.grpc.stub.StreamObserver<accessControl.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     * <pre>
     * server streaming remote procedure calls
     * user will send one request to the server and server will respond with stream of messages to the user
     * </pre>
     */
    public void authorization(accessControl.AuthorizationRequest request,
        io.grpc.stub.StreamObserver<accessControl.AuthorizationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAuthorizationMethod(), responseObserver);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public void logout(accessControl.LogoutRequest request,
        io.grpc.stub.StreamObserver<accessControl.LogoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                accessControl.LoginRequest,
                accessControl.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getAuthorizationMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                accessControl.AuthorizationRequest,
                accessControl.AuthorizationResponse>(
                  this, METHODID_AUTHORIZATION)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                accessControl.LogoutRequest,
                accessControl.LogoutResponse>(
                  this, METHODID_LOGOUT)))
          .build();
    }
  }

  /**
   * <pre>
   * the access control service definition
   * </pre>
   */
  public static final class accessControlStub extends io.grpc.stub.AbstractStub<accessControlStub> {
    private accessControlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private accessControlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected accessControlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new accessControlStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public void login(accessControl.LoginRequest request,
        io.grpc.stub.StreamObserver<accessControl.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * server streaming remote procedure calls
     * user will send one request to the server and server will respond with stream of messages to the user
     * </pre>
     */
    public void authorization(accessControl.AuthorizationRequest request,
        io.grpc.stub.StreamObserver<accessControl.AuthorizationResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getAuthorizationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public void logout(accessControl.LogoutRequest request,
        io.grpc.stub.StreamObserver<accessControl.LogoutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * the access control service definition
   * </pre>
   */
  public static final class accessControlBlockingStub extends io.grpc.stub.AbstractStub<accessControlBlockingStub> {
    private accessControlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private accessControlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected accessControlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new accessControlBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public accessControl.LoginResponse login(accessControl.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * server streaming remote procedure calls
     * user will send one request to the server and server will respond with stream of messages to the user
     * </pre>
     */
    public java.util.Iterator<accessControl.AuthorizationResponse> authorization(
        accessControl.AuthorizationRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getAuthorizationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public accessControl.LogoutResponse logout(accessControl.LogoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * the access control service definition
   * </pre>
   */
  public static final class accessControlFutureStub extends io.grpc.stub.AbstractStub<accessControlFutureStub> {
    private accessControlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private accessControlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected accessControlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new accessControlFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<accessControl.LoginResponse> login(
        accessControl.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * user will send one request and server will respond with one response
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<accessControl.LogoutResponse> logout(
        accessControl.LogoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_AUTHORIZATION = 1;
  private static final int METHODID_LOGOUT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final accessControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(accessControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((accessControl.LoginRequest) request,
              (io.grpc.stub.StreamObserver<accessControl.LoginResponse>) responseObserver);
          break;
        case METHODID_AUTHORIZATION:
          serviceImpl.authorization((accessControl.AuthorizationRequest) request,
              (io.grpc.stub.StreamObserver<accessControl.AuthorizationResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((accessControl.LogoutRequest) request,
              (io.grpc.stub.StreamObserver<accessControl.LogoutResponse>) responseObserver);
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

  private static abstract class accessControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    accessControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return accessControl.accessControlImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("accessControl");
    }
  }

  private static final class accessControlFileDescriptorSupplier
      extends accessControlBaseDescriptorSupplier {
    accessControlFileDescriptorSupplier() {}
  }

  private static final class accessControlMethodDescriptorSupplier
      extends accessControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    accessControlMethodDescriptorSupplier(String methodName) {
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
      synchronized (accessControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new accessControlFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getAuthorizationMethod())
              .addMethod(getLogoutMethod())
              .build();
        }
      }
    }
    return result;
  }
}

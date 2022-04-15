package lightingControl;

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
 * the lighting control service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: lightingControl.proto")
public final class lightingControlGrpc {

  private lightingControlGrpc() {}

  public static final String SERVICE_NAME = "lightingControl.lightingControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<lightingControl.LoginRequest,
      lightingControl.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = lightingControl.LoginRequest.class,
      responseType = lightingControl.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<lightingControl.LoginRequest,
      lightingControl.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<lightingControl.LoginRequest, lightingControl.LoginResponse> getLoginMethod;
    if ((getLoginMethod = lightingControlGrpc.getLoginMethod) == null) {
      synchronized (lightingControlGrpc.class) {
        if ((getLoginMethod = lightingControlGrpc.getLoginMethod) == null) {
          lightingControlGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<lightingControl.LoginRequest, lightingControl.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lightingControl.lightingControl", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lightingControl.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lightingControl.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new lightingControlMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<lightingControl.IntensityRequest,
      lightingControl.IntensityResponse> getSetIntensityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setIntensity",
      requestType = lightingControl.IntensityRequest.class,
      responseType = lightingControl.IntensityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<lightingControl.IntensityRequest,
      lightingControl.IntensityResponse> getSetIntensityMethod() {
    io.grpc.MethodDescriptor<lightingControl.IntensityRequest, lightingControl.IntensityResponse> getSetIntensityMethod;
    if ((getSetIntensityMethod = lightingControlGrpc.getSetIntensityMethod) == null) {
      synchronized (lightingControlGrpc.class) {
        if ((getSetIntensityMethod = lightingControlGrpc.getSetIntensityMethod) == null) {
          lightingControlGrpc.getSetIntensityMethod = getSetIntensityMethod = 
              io.grpc.MethodDescriptor.<lightingControl.IntensityRequest, lightingControl.IntensityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lightingControl.lightingControl", "setIntensity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lightingControl.IntensityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lightingControl.IntensityResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new lightingControlMethodDescriptorSupplier("setIntensity"))
                  .build();
          }
        }
     }
     return getSetIntensityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<lightingControl.LogoutRequest,
      lightingControl.LogoutResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logout",
      requestType = lightingControl.LogoutRequest.class,
      responseType = lightingControl.LogoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<lightingControl.LogoutRequest,
      lightingControl.LogoutResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<lightingControl.LogoutRequest, lightingControl.LogoutResponse> getLogoutMethod;
    if ((getLogoutMethod = lightingControlGrpc.getLogoutMethod) == null) {
      synchronized (lightingControlGrpc.class) {
        if ((getLogoutMethod = lightingControlGrpc.getLogoutMethod) == null) {
          lightingControlGrpc.getLogoutMethod = getLogoutMethod = 
              io.grpc.MethodDescriptor.<lightingControl.LogoutRequest, lightingControl.LogoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "lightingControl.lightingControl", "logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lightingControl.LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lightingControl.LogoutResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new lightingControlMethodDescriptorSupplier("logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static lightingControlStub newStub(io.grpc.Channel channel) {
    return new lightingControlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static lightingControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new lightingControlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static lightingControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new lightingControlFutureStub(channel);
  }

  /**
   * <pre>
   * the lighting control service definition
   * </pre>
   */
  public static abstract class lightingControlImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * unary remote procedure calls
     * </pre>
     */
    public void login(lightingControl.LoginRequest request,
        io.grpc.stub.StreamObserver<lightingControl.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     * <pre>
     * client streaming remote procedure calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<lightingControl.IntensityRequest> setIntensity(
        io.grpc.stub.StreamObserver<lightingControl.IntensityResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getSetIntensityMethod(), responseObserver);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * </pre>
     */
    public void logout(lightingControl.LogoutRequest request,
        io.grpc.stub.StreamObserver<lightingControl.LogoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lightingControl.LoginRequest,
                lightingControl.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getSetIntensityMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                lightingControl.IntensityRequest,
                lightingControl.IntensityResponse>(
                  this, METHODID_SET_INTENSITY)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                lightingControl.LogoutRequest,
                lightingControl.LogoutResponse>(
                  this, METHODID_LOGOUT)))
          .build();
    }
  }

  /**
   * <pre>
   * the lighting control service definition
   * </pre>
   */
  public static final class lightingControlStub extends io.grpc.stub.AbstractStub<lightingControlStub> {
    private lightingControlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private lightingControlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected lightingControlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new lightingControlStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * </pre>
     */
    public void login(lightingControl.LoginRequest request,
        io.grpc.stub.StreamObserver<lightingControl.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * client streaming remote procedure calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<lightingControl.IntensityRequest> setIntensity(
        io.grpc.stub.StreamObserver<lightingControl.IntensityResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getSetIntensityMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * </pre>
     */
    public void logout(lightingControl.LogoutRequest request,
        io.grpc.stub.StreamObserver<lightingControl.LogoutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * the lighting control service definition
   * </pre>
   */
  public static final class lightingControlBlockingStub extends io.grpc.stub.AbstractStub<lightingControlBlockingStub> {
    private lightingControlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private lightingControlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected lightingControlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new lightingControlBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * </pre>
     */
    public lightingControl.LoginResponse login(lightingControl.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * </pre>
     */
    public lightingControl.LogoutResponse logout(lightingControl.LogoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * the lighting control service definition
   * </pre>
   */
  public static final class lightingControlFutureStub extends io.grpc.stub.AbstractStub<lightingControlFutureStub> {
    private lightingControlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private lightingControlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected lightingControlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new lightingControlFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lightingControl.LoginResponse> login(
        lightingControl.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * unary remote procedure calls
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<lightingControl.LogoutResponse> logout(
        lightingControl.LogoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_LOGOUT = 1;
  private static final int METHODID_SET_INTENSITY = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final lightingControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(lightingControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((lightingControl.LoginRequest) request,
              (io.grpc.stub.StreamObserver<lightingControl.LoginResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((lightingControl.LogoutRequest) request,
              (io.grpc.stub.StreamObserver<lightingControl.LogoutResponse>) responseObserver);
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
        case METHODID_SET_INTENSITY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.setIntensity(
              (io.grpc.stub.StreamObserver<lightingControl.IntensityResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class lightingControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    lightingControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return lightingControl.lightingControlImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("lightingControl");
    }
  }

  private static final class lightingControlFileDescriptorSupplier
      extends lightingControlBaseDescriptorSupplier {
    lightingControlFileDescriptorSupplier() {}
  }

  private static final class lightingControlMethodDescriptorSupplier
      extends lightingControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    lightingControlMethodDescriptorSupplier(String methodName) {
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
      synchronized (lightingControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new lightingControlFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getSetIntensityMethod())
              .addMethod(getLogoutMethod())
              .build();
        }
      }
    }
    return result;
  }
}

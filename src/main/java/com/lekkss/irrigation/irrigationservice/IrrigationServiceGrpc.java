package com.lekkss.irrigation.irrigationservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: IrrigationService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IrrigationServiceGrpc {

  private IrrigationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.lekkss.irrigation.IrrigationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lekkss.irrigation.irrigationservice.IrrigationSoilData,
      com.lekkss.irrigation.irrigationservice.IrrigationResult> getCheckIrrigationNeededMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckIrrigationNeeded",
      requestType = com.lekkss.irrigation.irrigationservice.IrrigationSoilData.class,
      responseType = com.lekkss.irrigation.irrigationservice.IrrigationResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.lekkss.irrigation.irrigationservice.IrrigationSoilData,
      com.lekkss.irrigation.irrigationservice.IrrigationResult> getCheckIrrigationNeededMethod() {
    io.grpc.MethodDescriptor<com.lekkss.irrigation.irrigationservice.IrrigationSoilData, com.lekkss.irrigation.irrigationservice.IrrigationResult> getCheckIrrigationNeededMethod;
    if ((getCheckIrrigationNeededMethod = IrrigationServiceGrpc.getCheckIrrigationNeededMethod) == null) {
      synchronized (IrrigationServiceGrpc.class) {
        if ((getCheckIrrigationNeededMethod = IrrigationServiceGrpc.getCheckIrrigationNeededMethod) == null) {
          IrrigationServiceGrpc.getCheckIrrigationNeededMethod = getCheckIrrigationNeededMethod =
              io.grpc.MethodDescriptor.<com.lekkss.irrigation.irrigationservice.IrrigationSoilData, com.lekkss.irrigation.irrigationservice.IrrigationResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckIrrigationNeeded"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lekkss.irrigation.irrigationservice.IrrigationSoilData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lekkss.irrigation.irrigationservice.IrrigationResult.getDefaultInstance()))
              .setSchemaDescriptor(new IrrigationServiceMethodDescriptorSupplier("CheckIrrigationNeeded"))
              .build();
        }
      }
    }
    return getCheckIrrigationNeededMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest,
      com.lekkss.irrigation.irrigationservice.ToggleIrrigationResponse> getToggleIrrigationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ToggleIrrigation",
      requestType = com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest.class,
      responseType = com.lekkss.irrigation.irrigationservice.ToggleIrrigationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest,
      com.lekkss.irrigation.irrigationservice.ToggleIrrigationResponse> getToggleIrrigationMethod() {
    io.grpc.MethodDescriptor<com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest, com.lekkss.irrigation.irrigationservice.ToggleIrrigationResponse> getToggleIrrigationMethod;
    if ((getToggleIrrigationMethod = IrrigationServiceGrpc.getToggleIrrigationMethod) == null) {
      synchronized (IrrigationServiceGrpc.class) {
        if ((getToggleIrrigationMethod = IrrigationServiceGrpc.getToggleIrrigationMethod) == null) {
          IrrigationServiceGrpc.getToggleIrrigationMethod = getToggleIrrigationMethod =
              io.grpc.MethodDescriptor.<com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest, com.lekkss.irrigation.irrigationservice.ToggleIrrigationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ToggleIrrigation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lekkss.irrigation.irrigationservice.ToggleIrrigationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new IrrigationServiceMethodDescriptorSupplier("ToggleIrrigation"))
              .build();
        }
      }
    }
    return getToggleIrrigationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IrrigationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IrrigationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IrrigationServiceStub>() {
        @java.lang.Override
        public IrrigationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IrrigationServiceStub(channel, callOptions);
        }
      };
    return IrrigationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IrrigationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IrrigationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IrrigationServiceBlockingStub>() {
        @java.lang.Override
        public IrrigationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IrrigationServiceBlockingStub(channel, callOptions);
        }
      };
    return IrrigationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IrrigationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IrrigationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IrrigationServiceFutureStub>() {
        @java.lang.Override
        public IrrigationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IrrigationServiceFutureStub(channel, callOptions);
        }
      };
    return IrrigationServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<com.lekkss.irrigation.irrigationservice.IrrigationSoilData> checkIrrigationNeeded(
        io.grpc.stub.StreamObserver<com.lekkss.irrigation.irrigationservice.IrrigationResult> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getCheckIrrigationNeededMethod(), responseObserver);
    }

    /**
     */
    default void toggleIrrigation(com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest request,
        io.grpc.stub.StreamObserver<com.lekkss.irrigation.irrigationservice.ToggleIrrigationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getToggleIrrigationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service IrrigationService.
   */
  public static abstract class IrrigationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return IrrigationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service IrrigationService.
   */
  public static final class IrrigationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<IrrigationServiceStub> {
    private IrrigationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IrrigationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IrrigationServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.lekkss.irrigation.irrigationservice.IrrigationSoilData> checkIrrigationNeeded(
        io.grpc.stub.StreamObserver<com.lekkss.irrigation.irrigationservice.IrrigationResult> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getCheckIrrigationNeededMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void toggleIrrigation(com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest request,
        io.grpc.stub.StreamObserver<com.lekkss.irrigation.irrigationservice.ToggleIrrigationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getToggleIrrigationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service IrrigationService.
   */
  public static final class IrrigationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IrrigationServiceBlockingStub> {
    private IrrigationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IrrigationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IrrigationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.lekkss.irrigation.irrigationservice.ToggleIrrigationResponse toggleIrrigation(com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getToggleIrrigationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service IrrigationService.
   */
  public static final class IrrigationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<IrrigationServiceFutureStub> {
    private IrrigationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IrrigationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IrrigationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lekkss.irrigation.irrigationservice.ToggleIrrigationResponse> toggleIrrigation(
        com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getToggleIrrigationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TOGGLE_IRRIGATION = 0;
  private static final int METHODID_CHECK_IRRIGATION_NEEDED = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TOGGLE_IRRIGATION:
          serviceImpl.toggleIrrigation((com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest) request,
              (io.grpc.stub.StreamObserver<com.lekkss.irrigation.irrigationservice.ToggleIrrigationResponse>) responseObserver);
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
        case METHODID_CHECK_IRRIGATION_NEEDED:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.checkIrrigationNeeded(
              (io.grpc.stub.StreamObserver<com.lekkss.irrigation.irrigationservice.IrrigationResult>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCheckIrrigationNeededMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.lekkss.irrigation.irrigationservice.IrrigationSoilData,
              com.lekkss.irrigation.irrigationservice.IrrigationResult>(
                service, METHODID_CHECK_IRRIGATION_NEEDED)))
        .addMethod(
          getToggleIrrigationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.lekkss.irrigation.irrigationservice.ToggleIrrigationRequest,
              com.lekkss.irrigation.irrigationservice.ToggleIrrigationResponse>(
                service, METHODID_TOGGLE_IRRIGATION)))
        .build();
  }

  private static abstract class IrrigationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IrrigationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lekkss.irrigation.irrigationservice.IrrigationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IrrigationService");
    }
  }

  private static final class IrrigationServiceFileDescriptorSupplier
      extends IrrigationServiceBaseDescriptorSupplier {
    IrrigationServiceFileDescriptorSupplier() {}
  }

  private static final class IrrigationServiceMethodDescriptorSupplier
      extends IrrigationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IrrigationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IrrigationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IrrigationServiceFileDescriptorSupplier())
              .addMethod(getCheckIrrigationNeededMethod())
              .addMethod(getToggleIrrigationMethod())
              .build();
        }
      }
    }
    return result;
  }
}

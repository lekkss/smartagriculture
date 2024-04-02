package com.lekkss.irrigation.irrigationservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: IrrigationService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IrrigationGrpc {

  private IrrigationGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.lekkss.irrigation.Irrigation";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lekkss.irrigation.irrigationservice.SoilData,
      com.lekkss.irrigation.irrigationservice.IrrigationResult> getCheckIrrigationNeededMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckIrrigationNeeded",
      requestType = com.lekkss.irrigation.irrigationservice.SoilData.class,
      responseType = com.lekkss.irrigation.irrigationservice.IrrigationResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.lekkss.irrigation.irrigationservice.SoilData,
      com.lekkss.irrigation.irrigationservice.IrrigationResult> getCheckIrrigationNeededMethod() {
    io.grpc.MethodDescriptor<com.lekkss.irrigation.irrigationservice.SoilData, com.lekkss.irrigation.irrigationservice.IrrigationResult> getCheckIrrigationNeededMethod;
    if ((getCheckIrrigationNeededMethod = IrrigationGrpc.getCheckIrrigationNeededMethod) == null) {
      synchronized (IrrigationGrpc.class) {
        if ((getCheckIrrigationNeededMethod = IrrigationGrpc.getCheckIrrigationNeededMethod) == null) {
          IrrigationGrpc.getCheckIrrigationNeededMethod = getCheckIrrigationNeededMethod =
              io.grpc.MethodDescriptor.<com.lekkss.irrigation.irrigationservice.SoilData, com.lekkss.irrigation.irrigationservice.IrrigationResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckIrrigationNeeded"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lekkss.irrigation.irrigationservice.SoilData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lekkss.irrigation.irrigationservice.IrrigationResult.getDefaultInstance()))
              .setSchemaDescriptor(new IrrigationMethodDescriptorSupplier("CheckIrrigationNeeded"))
              .build();
        }
      }
    }
    return getCheckIrrigationNeededMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IrrigationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IrrigationStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IrrigationStub>() {
        @java.lang.Override
        public IrrigationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IrrigationStub(channel, callOptions);
        }
      };
    return IrrigationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IrrigationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IrrigationBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IrrigationBlockingStub>() {
        @java.lang.Override
        public IrrigationBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IrrigationBlockingStub(channel, callOptions);
        }
      };
    return IrrigationBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IrrigationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IrrigationFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<IrrigationFutureStub>() {
        @java.lang.Override
        public IrrigationFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new IrrigationFutureStub(channel, callOptions);
        }
      };
    return IrrigationFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<com.lekkss.irrigation.irrigationservice.SoilData> checkIrrigationNeeded(
        io.grpc.stub.StreamObserver<com.lekkss.irrigation.irrigationservice.IrrigationResult> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getCheckIrrigationNeededMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Irrigation.
   */
  public static abstract class IrrigationImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return IrrigationGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Irrigation.
   */
  public static final class IrrigationStub
      extends io.grpc.stub.AbstractAsyncStub<IrrigationStub> {
    private IrrigationStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IrrigationStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IrrigationStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.lekkss.irrigation.irrigationservice.SoilData> checkIrrigationNeeded(
        io.grpc.stub.StreamObserver<com.lekkss.irrigation.irrigationservice.IrrigationResult> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getCheckIrrigationNeededMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Irrigation.
   */
  public static final class IrrigationBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IrrigationBlockingStub> {
    private IrrigationBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IrrigationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IrrigationBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Irrigation.
   */
  public static final class IrrigationFutureStub
      extends io.grpc.stub.AbstractFutureStub<IrrigationFutureStub> {
    private IrrigationFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IrrigationFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IrrigationFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CHECK_IRRIGATION_NEEDED = 0;

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
              com.lekkss.irrigation.irrigationservice.SoilData,
              com.lekkss.irrigation.irrigationservice.IrrigationResult>(
                service, METHODID_CHECK_IRRIGATION_NEEDED)))
        .build();
  }

  private static abstract class IrrigationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IrrigationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lekkss.irrigation.irrigationservice.IrrigationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Irrigation");
    }
  }

  private static final class IrrigationFileDescriptorSupplier
      extends IrrigationBaseDescriptorSupplier {
    IrrigationFileDescriptorSupplier() {}
  }

  private static final class IrrigationMethodDescriptorSupplier
      extends IrrigationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IrrigationMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IrrigationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IrrigationFileDescriptorSupplier())
              .addMethod(getCheckIrrigationNeededMethod())
              .build();
        }
      }
    }
    return result;
  }
}

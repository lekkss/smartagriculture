package com.lekkss.soilsensor.soilsensorservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(value = "by gRPC proto compiler (version 1.61.1)", comments = "Source: SoilSensorService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SoilSensorServiceGrpc {

  private SoilSensorServiceGrpc() {
  }

  public static final java.lang.String SERVICE_NAME = "com.lekkss.soilsensor.SoilSensorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lekkss.soilsensor.soilsensorservice.GetSoilDataRequest, com.lekkss.soilsensor.soilsensorservice.SoilData> getGetSoilDataMethod;

  @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
      + "GetSoilData", requestType = com.lekkss.soilsensor.soilsensorservice.GetSoilDataRequest.class, responseType = com.lekkss.soilsensor.soilsensorservice.SoilData.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lekkss.soilsensor.soilsensorservice.GetSoilDataRequest, com.lekkss.soilsensor.soilsensorservice.SoilData> getGetSoilDataMethod() {
    io.grpc.MethodDescriptor<com.lekkss.soilsensor.soilsensorservice.GetSoilDataRequest, com.lekkss.soilsensor.soilsensorservice.SoilData> getGetSoilDataMethod;
    if ((getGetSoilDataMethod = SoilSensorServiceGrpc.getGetSoilDataMethod) == null) {
      synchronized (SoilSensorServiceGrpc.class) {
        if ((getGetSoilDataMethod = SoilSensorServiceGrpc.getGetSoilDataMethod) == null) {
          SoilSensorServiceGrpc.getGetSoilDataMethod = getGetSoilDataMethod = io.grpc.MethodDescriptor.<com.lekkss.soilsensor.soilsensorservice.GetSoilDataRequest, com.lekkss.soilsensor.soilsensorservice.SoilData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSoilData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lekkss.soilsensor.soilsensorservice.GetSoilDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lekkss.soilsensor.soilsensorservice.SoilData.getDefaultInstance()))
              .setSchemaDescriptor(new SoilSensorServiceMethodDescriptorSupplier("GetSoilData"))
              .build();
        }
      }
    }
    return getGetSoilDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lekkss.soilsensor.soilsensorservice.StreamSoilDataRequest, com.lekkss.soilsensor.soilsensorservice.SoilData> getStreamSoilDataMethod;

  @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
      + "StreamSoilData", requestType = com.lekkss.soilsensor.soilsensorservice.StreamSoilDataRequest.class, responseType = com.lekkss.soilsensor.soilsensorservice.SoilData.class, methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.lekkss.soilsensor.soilsensorservice.StreamSoilDataRequest, com.lekkss.soilsensor.soilsensorservice.SoilData> getStreamSoilDataMethod() {
    io.grpc.MethodDescriptor<com.lekkss.soilsensor.soilsensorservice.StreamSoilDataRequest, com.lekkss.soilsensor.soilsensorservice.SoilData> getStreamSoilDataMethod;
    if ((getStreamSoilDataMethod = SoilSensorServiceGrpc.getStreamSoilDataMethod) == null) {
      synchronized (SoilSensorServiceGrpc.class) {
        if ((getStreamSoilDataMethod = SoilSensorServiceGrpc.getStreamSoilDataMethod) == null) {
          SoilSensorServiceGrpc.getStreamSoilDataMethod = getStreamSoilDataMethod = io.grpc.MethodDescriptor.<com.lekkss.soilsensor.soilsensorservice.StreamSoilDataRequest, com.lekkss.soilsensor.soilsensorservice.SoilData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamSoilData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lekkss.soilsensor.soilsensorservice.StreamSoilDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lekkss.soilsensor.soilsensorservice.SoilData.getDefaultInstance()))
              .setSchemaDescriptor(new SoilSensorServiceMethodDescriptorSupplier("StreamSoilData"))
              .build();
        }
      }
    }
    return getStreamSoilDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SoilSensorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoilSensorServiceStub> factory = new io.grpc.stub.AbstractStub.StubFactory<SoilSensorServiceStub>() {
      @java.lang.Override
      public SoilSensorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
        return new SoilSensorServiceStub(channel, callOptions);
      }
    };
    return SoilSensorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output
   * calls on the service
   */
  public static SoilSensorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoilSensorServiceBlockingStub> factory = new io.grpc.stub.AbstractStub.StubFactory<SoilSensorServiceBlockingStub>() {
      @java.lang.Override
      public SoilSensorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
        return new SoilSensorServiceBlockingStub(channel, callOptions);
      }
    };
    return SoilSensorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the
   * service
   */
  public static SoilSensorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SoilSensorServiceFutureStub> factory = new io.grpc.stub.AbstractStub.StubFactory<SoilSensorServiceFutureStub>() {
      @java.lang.Override
      public SoilSensorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
        return new SoilSensorServiceFutureStub(channel, callOptions);
      }
    };
    return SoilSensorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getSoilData(com.lekkss.soilsensor.soilsensorservice.GetSoilDataRequest request,
        io.grpc.stub.StreamObserver<com.lekkss.soilsensor.soilsensorservice.SoilData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSoilDataMethod(), responseObserver);
    }

    /**
     * @throws InterruptedException
     */
    default void streamSoilData(com.lekkss.soilsensor.soilsensorservice.StreamSoilDataRequest request,
        io.grpc.stub.StreamObserver<com.lekkss.soilsensor.soilsensorservice.SoilData> responseObserver)
        throws InterruptedException {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamSoilDataMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SoilSensorService.
   */
  public static abstract class SoilSensorServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SoilSensorServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service
   * SoilSensorService.
   */
  public static final class SoilSensorServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SoilSensorServiceStub> {
    private SoilSensorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoilSensorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoilSensorServiceStub(channel, callOptions);
    }

    /**
     */
    public void getSoilData(com.lekkss.soilsensor.soilsensorservice.GetSoilDataRequest request,
        io.grpc.stub.StreamObserver<com.lekkss.soilsensor.soilsensorservice.SoilData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSoilDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamSoilData(com.lekkss.soilsensor.soilsensorservice.StreamSoilDataRequest request,
        io.grpc.stub.StreamObserver<com.lekkss.soilsensor.soilsensorservice.SoilData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamSoilDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service
   * SoilSensorService.
   */
  public static final class SoilSensorServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SoilSensorServiceBlockingStub> {
    private SoilSensorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoilSensorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoilSensorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.lekkss.soilsensor.soilsensorservice.SoilData getSoilData(
        com.lekkss.soilsensor.soilsensorservice.GetSoilDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSoilDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.lekkss.soilsensor.soilsensorservice.SoilData> streamSoilData(
        com.lekkss.soilsensor.soilsensorservice.StreamSoilDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamSoilDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * SoilSensorService.
   */
  public static final class SoilSensorServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SoilSensorServiceFutureStub> {
    private SoilSensorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SoilSensorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SoilSensorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lekkss.soilsensor.soilsensorservice.SoilData> getSoilData(
        com.lekkss.soilsensor.soilsensorservice.GetSoilDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSoilDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SOIL_DATA = 0;
  private static final int METHODID_STREAM_SOIL_DATA = 1;

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
        case METHODID_GET_SOIL_DATA:
          serviceImpl.getSoilData((com.lekkss.soilsensor.soilsensorservice.GetSoilDataRequest) request,
              (io.grpc.stub.StreamObserver<com.lekkss.soilsensor.soilsensorservice.SoilData>) responseObserver);
          break;
        case METHODID_STREAM_SOIL_DATA:
          try {
            serviceImpl.streamSoilData((com.lekkss.soilsensor.soilsensorservice.StreamSoilDataRequest) request,
                (io.grpc.stub.StreamObserver<com.lekkss.soilsensor.soilsensorservice.SoilData>) responseObserver);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getGetSoilDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.lekkss.soilsensor.soilsensorservice.GetSoilDataRequest, com.lekkss.soilsensor.soilsensorservice.SoilData>(
                    service, METHODID_GET_SOIL_DATA)))
        .addMethod(
            getStreamSoilDataMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
                new MethodHandlers<com.lekkss.soilsensor.soilsensorservice.StreamSoilDataRequest, com.lekkss.soilsensor.soilsensorservice.SoilData>(
                    service, METHODID_STREAM_SOIL_DATA)))
        .build();
  }

  private static abstract class SoilSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SoilSensorServiceBaseDescriptorSupplier() {
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lekkss.soilsensor.soilsensorservice.SoilSensorServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SoilSensorService");
    }
  }

  private static final class SoilSensorServiceFileDescriptorSupplier
      extends SoilSensorServiceBaseDescriptorSupplier {
    SoilSensorServiceFileDescriptorSupplier() {
    }
  }

  private static final class SoilSensorServiceMethodDescriptorSupplier
      extends SoilSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SoilSensorServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SoilSensorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SoilSensorServiceFileDescriptorSupplier())
              .addMethod(getGetSoilDataMethod())
              .addMethod(getStreamSoilDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}

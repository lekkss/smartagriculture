package com.lekkss.weathersensor.weathersensorservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.1)",
    comments = "Source: WeatherSensorService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WeatherSensorServiceGrpc {

  private WeatherSensorServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.lekkss.weathersensor.WeatherSensorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lekkss.weathersensor.weathersensorservice.LocationCoordinates,
      com.lekkss.weathersensor.weathersensorservice.WeatherData> getGetWeatherForecastMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWeatherForecast",
      requestType = com.lekkss.weathersensor.weathersensorservice.LocationCoordinates.class,
      responseType = com.lekkss.weathersensor.weathersensorservice.WeatherData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lekkss.weathersensor.weathersensorservice.LocationCoordinates,
      com.lekkss.weathersensor.weathersensorservice.WeatherData> getGetWeatherForecastMethod() {
    io.grpc.MethodDescriptor<com.lekkss.weathersensor.weathersensorservice.LocationCoordinates, com.lekkss.weathersensor.weathersensorservice.WeatherData> getGetWeatherForecastMethod;
    if ((getGetWeatherForecastMethod = WeatherSensorServiceGrpc.getGetWeatherForecastMethod) == null) {
      synchronized (WeatherSensorServiceGrpc.class) {
        if ((getGetWeatherForecastMethod = WeatherSensorServiceGrpc.getGetWeatherForecastMethod) == null) {
          WeatherSensorServiceGrpc.getGetWeatherForecastMethod = getGetWeatherForecastMethod =
              io.grpc.MethodDescriptor.<com.lekkss.weathersensor.weathersensorservice.LocationCoordinates, com.lekkss.weathersensor.weathersensorservice.WeatherData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWeatherForecast"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lekkss.weathersensor.weathersensorservice.LocationCoordinates.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lekkss.weathersensor.weathersensorservice.WeatherData.getDefaultInstance()))
              .setSchemaDescriptor(new WeatherSensorServiceMethodDescriptorSupplier("GetWeatherForecast"))
              .build();
        }
      }
    }
    return getGetWeatherForecastMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lekkss.weathersensor.weathersensorservice.LocationCoordinates,
      com.lekkss.weathersensor.weathersensorservice.WeatherData> getGetAverageWeatherForcastMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAverageWeatherForcast",
      requestType = com.lekkss.weathersensor.weathersensorservice.LocationCoordinates.class,
      responseType = com.lekkss.weathersensor.weathersensorservice.WeatherData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.lekkss.weathersensor.weathersensorservice.LocationCoordinates,
      com.lekkss.weathersensor.weathersensorservice.WeatherData> getGetAverageWeatherForcastMethod() {
    io.grpc.MethodDescriptor<com.lekkss.weathersensor.weathersensorservice.LocationCoordinates, com.lekkss.weathersensor.weathersensorservice.WeatherData> getGetAverageWeatherForcastMethod;
    if ((getGetAverageWeatherForcastMethod = WeatherSensorServiceGrpc.getGetAverageWeatherForcastMethod) == null) {
      synchronized (WeatherSensorServiceGrpc.class) {
        if ((getGetAverageWeatherForcastMethod = WeatherSensorServiceGrpc.getGetAverageWeatherForcastMethod) == null) {
          WeatherSensorServiceGrpc.getGetAverageWeatherForcastMethod = getGetAverageWeatherForcastMethod =
              io.grpc.MethodDescriptor.<com.lekkss.weathersensor.weathersensorservice.LocationCoordinates, com.lekkss.weathersensor.weathersensorservice.WeatherData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAverageWeatherForcast"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lekkss.weathersensor.weathersensorservice.LocationCoordinates.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lekkss.weathersensor.weathersensorservice.WeatherData.getDefaultInstance()))
              .setSchemaDescriptor(new WeatherSensorServiceMethodDescriptorSupplier("GetAverageWeatherForcast"))
              .build();
        }
      }
    }
    return getGetAverageWeatherForcastMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WeatherSensorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WeatherSensorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WeatherSensorServiceStub>() {
        @java.lang.Override
        public WeatherSensorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WeatherSensorServiceStub(channel, callOptions);
        }
      };
    return WeatherSensorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WeatherSensorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WeatherSensorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WeatherSensorServiceBlockingStub>() {
        @java.lang.Override
        public WeatherSensorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WeatherSensorServiceBlockingStub(channel, callOptions);
        }
      };
    return WeatherSensorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WeatherSensorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WeatherSensorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WeatherSensorServiceFutureStub>() {
        @java.lang.Override
        public WeatherSensorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WeatherSensorServiceFutureStub(channel, callOptions);
        }
      };
    return WeatherSensorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getWeatherForecast(com.lekkss.weathersensor.weathersensorservice.LocationCoordinates request,
        io.grpc.stub.StreamObserver<com.lekkss.weathersensor.weathersensorservice.WeatherData> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWeatherForecastMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.lekkss.weathersensor.weathersensorservice.LocationCoordinates> getAverageWeatherForcast(
        io.grpc.stub.StreamObserver<com.lekkss.weathersensor.weathersensorservice.WeatherData> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetAverageWeatherForcastMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WeatherSensorService.
   */
  public static abstract class WeatherSensorServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WeatherSensorServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WeatherSensorService.
   */
  public static final class WeatherSensorServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WeatherSensorServiceStub> {
    private WeatherSensorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherSensorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WeatherSensorServiceStub(channel, callOptions);
    }

    /**
     */
    public void getWeatherForecast(com.lekkss.weathersensor.weathersensorservice.LocationCoordinates request,
        io.grpc.stub.StreamObserver<com.lekkss.weathersensor.weathersensorservice.WeatherData> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWeatherForecastMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.lekkss.weathersensor.weathersensorservice.LocationCoordinates> getAverageWeatherForcast(
        io.grpc.stub.StreamObserver<com.lekkss.weathersensor.weathersensorservice.WeatherData> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getGetAverageWeatherForcastMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WeatherSensorService.
   */
  public static final class WeatherSensorServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WeatherSensorServiceBlockingStub> {
    private WeatherSensorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherSensorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WeatherSensorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.lekkss.weathersensor.weathersensorservice.WeatherData getWeatherForecast(com.lekkss.weathersensor.weathersensorservice.LocationCoordinates request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWeatherForecastMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WeatherSensorService.
   */
  public static final class WeatherSensorServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WeatherSensorServiceFutureStub> {
    private WeatherSensorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeatherSensorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WeatherSensorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lekkss.weathersensor.weathersensorservice.WeatherData> getWeatherForecast(
        com.lekkss.weathersensor.weathersensorservice.LocationCoordinates request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWeatherForecastMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_WEATHER_FORECAST = 0;
  private static final int METHODID_GET_AVERAGE_WEATHER_FORCAST = 1;

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
        case METHODID_GET_WEATHER_FORECAST:
          serviceImpl.getWeatherForecast((com.lekkss.weathersensor.weathersensorservice.LocationCoordinates) request,
              (io.grpc.stub.StreamObserver<com.lekkss.weathersensor.weathersensorservice.WeatherData>) responseObserver);
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
        case METHODID_GET_AVERAGE_WEATHER_FORCAST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getAverageWeatherForcast(
              (io.grpc.stub.StreamObserver<com.lekkss.weathersensor.weathersensorservice.WeatherData>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetWeatherForecastMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.lekkss.weathersensor.weathersensorservice.LocationCoordinates,
              com.lekkss.weathersensor.weathersensorservice.WeatherData>(
                service, METHODID_GET_WEATHER_FORECAST)))
        .addMethod(
          getGetAverageWeatherForcastMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.lekkss.weathersensor.weathersensorservice.LocationCoordinates,
              com.lekkss.weathersensor.weathersensorservice.WeatherData>(
                service, METHODID_GET_AVERAGE_WEATHER_FORCAST)))
        .build();
  }

  private static abstract class WeatherSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WeatherSensorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lekkss.weathersensor.weathersensorservice.WeatherSensorServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WeatherSensorService");
    }
  }

  private static final class WeatherSensorServiceFileDescriptorSupplier
      extends WeatherSensorServiceBaseDescriptorSupplier {
    WeatherSensorServiceFileDescriptorSupplier() {}
  }

  private static final class WeatherSensorServiceMethodDescriptorSupplier
      extends WeatherSensorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WeatherSensorServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (WeatherSensorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WeatherSensorServiceFileDescriptorSupplier())
              .addMethod(getGetWeatherForecastMethod())
              .addMethod(getGetAverageWeatherForcastMethod())
              .build();
        }
      }
    }
    return result;
  }
}

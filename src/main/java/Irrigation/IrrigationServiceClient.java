package Irrigation;

import java.util.concurrent.TimeUnit;

import com.lekkss.irrigation.irrigationservice.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class IrrigationServiceClient {
    private final ManagedChannel channel;
    private final IrrigationServiceGrpc.IrrigationServiceStub stub;

    public IrrigationServiceClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        this.stub = IrrigationServiceGrpc.newStub(channel);
    }

    public void checkIrrigation() {
        StreamObserver<IrrigationSoilData> requestObserver = stub
                .checkIrrigationNeeded(new StreamObserver<IrrigationResult>() {
                    @Override
                    public void onNext(IrrigationResult irrigationResult) {
                        if (irrigationResult.getIrrigationNeeded()) {
                            System.out.println("Irrigation is Needed");
                        } else {
                            System.out.println("Irrigation not needed");
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Error: " + throwable.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Stream completed");
                    }
                });
        // Simulate sending soil sensor data to the server
        // Replace this with actual soil sensor data streaming logic
        for (int i = 0; i < 1000; i++) {
            IrrigationSoilData soilData = IrrigationSoilData.newBuilder()
                    .setTemperature(25.0 + i)
                    .setSoilNutrients(0.6 + i)
                    .setSoilHumidity(0.4 + i)
                    .build();
            requestObserver.onNext(soilData);
        }

        // Indicate the end of streaming
        requestObserver.onCompleted();
    }

    public void shutdown() {
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Error while shutting down client: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        IrrigationServiceClient client = new IrrigationServiceClient("localhost", 5051);
        try {
            client.checkIrrigation();
        } finally {
            client.shutdown();
        }
    }
}

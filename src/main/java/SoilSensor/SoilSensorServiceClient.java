package SoilSensor;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.lekkss.soilsensor.soilsensorservice.GetSoilDataRequest;
import com.lekkss.soilsensor.soilsensorservice.SoilData;
import com.lekkss.soilsensor.soilsensorservice.SoilSensorServiceGrpc;
import com.lekkss.soilsensor.soilsensorservice.StreamSoilDataRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class SoilSensorServiceClient {
    private final ManagedChannel channel;
    private final SoilSensorServiceGrpc.SoilSensorServiceStub stub;

    public SoilSensorServiceClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        this.stub = SoilSensorServiceGrpc.newStub(channel);
    }

    public void getSoilData(String time) {
        GetSoilDataRequest soilDataRequest = GetSoilDataRequest.newBuilder().setTime(time).build();
        stub.getSoilData(soilDataRequest, new StreamObserver<SoilData>() {

            @Override
            public void onNext(SoilData responseData) {
                System.out.println("---------SoilData at: " + time + " ---------" +
                        "\nTemperature(°C) " + responseData.getTemperature() +
                        "\nHumidiy " + responseData.getSoilHumidity() +
                        "\nSoil Nutrient " + responseData.getSoilNutrients());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("---------Soil Sensor Service Streaming completed---------");
            }

        });
    }

    public void streamSoilServerRequest() {
        StreamObserver<SoilData> responseObserver = new StreamObserver<SoilData>() {
            @Override
            public void onNext(SoilData soilData) {
                // Process incoming soil sensor data
                System.out.println("---------Soil data received---------" +
                        "\nTime of Day: " + soilData.getTimeOfDay() +
                        "\nTemperature(°C): " + soilData.getTemperature() +
                        "\nHumidiy: " + soilData.getSoilHumidity() +
                        "\nSoil Nutrient: " + soilData.getSoilNutrients());
            }

            @Override
            public void onError(Throwable throwable) {
                // Handle error
                System.out.println("Error: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                // Stream completed
                System.out.println("---------Soil Sensor Service Streaming completed---------");
            }
        };
        stub.streamSoilData(StreamSoilDataRequest.newBuilder().build(), responseObserver);
    }

    public void shutdown() {
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Error while shutting down client: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SoilSensorServiceClient client = new SoilSensorServiceClient("localhost", 5000);
        client.streamSoilServerRequest();
        client.getSoilData("0:15");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Press 'Q' to quit");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                client.shutdown();
                break;
            }
        }
    }

}

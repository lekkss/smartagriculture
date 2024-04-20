package SoilSensor;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import com.lekkss.soilsensor.soilsensorservice.GetSoilDataRequest;
import com.lekkss.soilsensor.soilsensorservice.SoilData;
import com.lekkss.soilsensor.soilsensorservice.SoilSensorServiceGrpc;
import com.lekkss.soilsensor.soilsensorservice.StreamSoilDataRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class SoilSensorServiceClient {
    private final ManagedChannel channel;
    private final SoilSensorServiceGrpc.SoilSensorServiceStub stub;

    public SoilSensorServiceClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        this.stub = SoilSensorServiceGrpc.newStub(channel);
    }

    public void getSoilData(String time, Text text) {
        GetSoilDataRequest soilDataRequest = GetSoilDataRequest.newBuilder().setTime(time).build();
        stub.getSoilData(soilDataRequest, new StreamObserver<SoilData>() {
            @Override
            public void onNext(SoilData responseData) {
                Platform.runLater(() -> text.setText("Soil Data at time = " + time + "\n" +
                        "Temperature: " + responseData.getTemperature() + "\n" +
                        "Humidity: " + responseData.getSoilHumidity() + "\n" +
                        "Soil Nutrient: " + responseData.getSoilNutrients()));
            }
            @Override
            public void onError(Throwable t) {
                Platform.runLater(() -> {
                    System.out.println("Error: " + t.getMessage());
                });
            }

            @Override
            public void onCompleted() {
                // Handle completion if needed
            }
        });
    }


    public void streamSoilServerRequest(Text text) {
        // Create a StreamObserver to handle streamed data
        StreamObserver<SoilData> responseObserver = new StreamObserver<SoilData>() {
            @Override
            public void onNext(SoilData soilData) {
                Platform.runLater(() -> text.setText("Soil Data at:  " + soilData.getTimeOfDay() + "\n" +
                        "\"Temperature(°C) \": " + soilData.getTemperature() + "\n" +
                        "Humidity: " + soilData.getSoilHumidity() + "\n" +
                        "Soil Nutrient: " + soilData.getSoilNutrients()));
            }
            @Override
            public void onError(Throwable throwable) {
                // Handle error if needed
                Platform.runLater(() -> System.out.println("Error: " + throwable.getMessage()));
            }
            @Override
            public void onCompleted() {
                // Handle completion if needed
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

    // public static void main(String[] args) {
    // SoilSensorServiceClient client = new SoilSensorServiceClient("localhost",
    // 5000);
    // // client.streamSoilServerRequest();
    // // client.getSoilData("0:15");
    // Scanner scanner = new Scanner(System.in);
    // while (true) {
    // System.out.println("Press 'Q' to quit");
    // String input = scanner.nextLine();
    // if (input.equalsIgnoreCase("Q")) {
    // client.shutdown();
    // break;
    // }
    // }
    // }

}

package SoilSensor;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import com.lekkss.soilsensor.soilsensorservice.GetSoilDataRequest;
import com.lekkss.soilsensor.soilsensorservice.SoilData;
import com.lekkss.soilsensor.soilsensorservice.SoilSensorServiceGrpc;
import com.lekkss.soilsensor.soilsensorservice.StreamSoilDataRequest;

import controller.ChartUpdater;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class SoilSensorServiceClient {
    private final ManagedChannel channel;
    private final SoilSensorServiceGrpc.SoilSensorServiceStub stub;
    private final ChartUpdater chartUpdater;

    public SoilSensorServiceClient(String host, int port, ChartUpdater chartUpdater) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        this.stub = SoilSensorServiceGrpc.newStub(channel);
        this.chartUpdater = chartUpdater;
    }


    public void getSoilData(String time, Label t, Label temp, Label humidityLabel, Label nutrient) {
        GetSoilDataRequest soilDataRequest = GetSoilDataRequest.newBuilder().setTime(time).build();
        stub.getSoilData(soilDataRequest, new StreamObserver<SoilData>() {
            @Override
            public void onNext(SoilData responseData) {
                Platform.runLater(() -> {
                    t.setText(time);
                    temp.setText(String.valueOf(responseData.getTemperature()));
                    humidityLabel.setText(String.valueOf(responseData.getSoilHumidity()));
                    nutrient.setText(String.valueOf(responseData.getSoilNutrients()));


                });
            }
            @Override
            public void onError(Throwable t) {
                Platform.runLater(() -> {
                    System.out.println("Error: " + t.getMessage());
                });
            }

            @Override
            public void onCompleted() {
                System.out.println("Completed");
            }
        });
    }


    public void streamSoilServerRequest(Label time, Label temp, Label humidity, Label nutrient, Runnable updateUI) {
        StreamObserver<SoilData> responseObserver = new StreamObserver<SoilData>() {
            @Override
            public void onNext(SoilData soilData) {
                Platform.runLater(() -> {
                    time.setText(soilData.getTimeOfDay());
                    temp.setText(String.valueOf(soilData.getTemperature()));
                    humidity.setText(String.valueOf(soilData.getSoilHumidity()));
                    nutrient.setText(String.valueOf(soilData.getSoilNutrients()));

                    chartUpdater.updateChart(soilData.getTimeOfDay(), soilData.getTemperature());
                    updateUI.run();
                });
            }

            @Override
            public void onError(Throwable throwable) {
                Platform.runLater(() -> System.out.println("Stream error: " + throwable.getMessage()));
            }

            @Override
            public void onCompleted() {
                Platform.runLater(() -> System.out.println("Stream completed"));
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
    // 5003);
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

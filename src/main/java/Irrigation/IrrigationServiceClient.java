package Irrigation;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.lekkss.irrigation.irrigationservice.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class IrrigationServiceClient {
    private static final String CSV_FILE_PATH = "src/main/java/SoilSensor/soil_sensor_data.csv";

    private final ManagedChannel channel;
    private final IrrigationServiceGrpc.IrrigationServiceStub stub;

    public IrrigationServiceClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        this.stub = IrrigationServiceGrpc.newStub(channel);
    }

    public void checkIrrigation(Text text, Circle sensorLight) {
        try (InputStream input = Files.newInputStream(Paths.get(CSV_FILE_PATH));
             Reader reader = new InputStreamReader(input);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            // Create a StreamObserver to handle streamed data
            StreamObserver<IrrigationSoilData> requestObserver = stub
                    .checkIrrigationNeeded(new StreamObserver<IrrigationResult>() {
                        @Override
                        public void onNext(IrrigationResult irrigationResult) {
                            // Update the text with the irrigation status for each streamed value
                            Platform.runLater(() -> {
                                text.setText(irrigationResult.getIrrigationNeeded() ? "irrigate" : "turn off");
                                // Change color of sensorLight based on response
                                sensorLight.setFill(irrigationResult.getIrrigationNeeded() ? Color.GREEN : Color.RED);
                            });
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            // Handle error
                            Platform.runLater(() ->
                                    System.out.println("Error: " + throwable.getMessage()));
                        }

                        @Override
                        public void onCompleted() {
                            // Handle stream completion
                            Platform.runLater(() ->
                                    System.out.println("Stream Irrigation completed"));
                        }
                    });

            // Iterate through CSV records and send each record's data
            for (CSVRecord record : csvParser) {
                float temperature = Float.parseFloat(record.get("Temperature (°C)"));
                float soilNutrients = Float.parseFloat(record.get("Soil Nutrients"));
                float soilHumidity = Float.parseFloat(record.get("Soil Humidity"));

                IrrigationSoilData soilData = IrrigationSoilData.newBuilder()
                        .setTemperature(temperature)
                        .setSoilNutrients(soilNutrients)
                        .setSoilHumidity(soilHumidity)
                        .build();

                // Send each record's data
                requestObserver.onNext(soilData);

                // Simulate delay
                TimeUnit.MILLISECONDS.sleep(2000);
            }

            // Indicate that all data has been sent
            requestObserver.onCompleted();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }




    public void shutdown() {
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Error while shutting down client: " + e.getMessage());
        }
    }

//    private void toggleIrrigation(boolean enable) {
//        if (enable) {
//            System.out.println("Turning on irrigation");
//
//        } else {
//            System.out.println("Turning off irrigation");
//
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        IrrigationServiceClient client = new IrrigationServiceClient("localhost", 5051);
//        client.checkIrrigation();
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

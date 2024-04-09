package Irrigation;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

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

    public void checkIrrigation(String filePath) throws InterruptedException {
        try (FileReader reader = new FileReader(filePath);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            StreamObserver<IrrigationSoilData> requestObserver = stub
                    .checkIrrigationNeeded(new StreamObserver<IrrigationResult>() {
                        @Override
                        public void onNext(IrrigationResult irrigationResult) {
                            toggleIrrigation(irrigationResult.getIrrigationNeeded());
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            System.out.println("Error: " + throwable.getMessage());
                        }

                        @Override
                        public void onCompleted() {
                            System.out.println("Stream Irrigation completed");
                        }
                    });

            for (CSVRecord record : csvParser) {
                float temperature = Float.parseFloat(record.get("Temperature (°C)"));
                float soilNutrients = Float.parseFloat(record.get("Soil Nutrients"));
                float soilHumidity = Float.parseFloat(record.get("Soil Humidity"));

                IrrigationSoilData soilData = IrrigationSoilData.newBuilder()
                        .setTemperature(temperature)
                        .setSoilNutrients(soilNutrients)
                        .setSoilHumidity(soilHumidity)
                        .build();
                TimeUnit.MILLISECONDS.sleep(7000);
                requestObserver.onNext(soilData);
            }

            requestObserver.onCompleted();
        } catch (IOException e) {
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

    private void toggleIrrigation(boolean enable) {
        if (enable) {
            System.out.println("Turning on irrigation");

        } else {
            System.out.println("Turning off irrigation");

        }
    }

    // public static void main(String[] args) throws InterruptedException {
    // IrrigationServiceClient client = new IrrigationServiceClient("localhost",
    // 5051);
    // try {

    // Scanner scanner = new Scanner(System.in);
    // System.out.println(
    // "Press 1 to start streaming, press 2 to get current SoilData information or
    // press Q to quit");

    // String input = scanner.nextLine();
    // while (input != "q") {
    // // System.out.println("Press 'Q' to quit");

    // if (input.equalsIgnoreCase("1")) {
    // client.checkIrrigation(
    // "C:\\Users\\lekkss\\Desktop\\Distributed
    // System\\smartagriculture\\src\\main\\java\\SoilSensor\\soil_sensor_data.csv");
    // if (input.equalsIgnoreCase("Q")) {
    // client.shutdown();
    // break;
    // }

    // } else if (input.equalsIgnoreCase("2")) {
    // System.out.println("Gotten Data");
    // } else if (input.equalsIgnoreCase("Q")) {
    // client.shutdown();
    // break;
    // } else {
    // System.out.println("Enter a valid input");
    // }
    // }
    // } finally {
    // client.shutdown();
    // }
    // }

    public static void main(String[] args) throws InterruptedException {
        IrrigationServiceClient client = new IrrigationServiceClient("localhost", 5051);

        try {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println(
                        "Press 1 to start streaming, press 2 to get current SoilData information, or press Q to quit");

                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("1")) {
                    streamData(client, scanner);
                } else if (input.equalsIgnoreCase("2")) {
                    showCurrentData(client);
                } else if (input.equalsIgnoreCase("Q")) {
                    break;
                } else {
                    System.out.println("Enter a valid input");
                }
            }
        } finally {
            client.shutdown();
        }
    }

    private static void streamData(IrrigationServiceClient client, Scanner scanner) {
        System.out.println("Starting data streaming...");
        try {
            client.checkIrrigation(
                    "C:\\Users\\lekkss\\Desktop\\Distributed System\\smartagriculture\\src\\main\\java\\SoilSensor\\soil_sensor_data.csv");
            while (true) {
                if (scanner.hasNextLine()) {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("Q")) {
                        System.out.println("Stopping data streaming.");
                        client.shutdown(); // Method to stop streaming
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Streaming complete. Press Enter to return to the main menu.");
        // Wait for user input to return to main menu
        new Scanner(System.in).nextLine();
    }

    private static void showCurrentData(IrrigationServiceClient client) {
        System.out.println("Getting current data...");
        // Call the method to get current soil data
        System.out.println("Current data received. Press Enter to return to the main menu.");
        // Wait for user input to return to main menu
        new Scanner(System.in).nextLine();
    }

}

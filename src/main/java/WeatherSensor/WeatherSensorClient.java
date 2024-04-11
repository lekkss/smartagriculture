package WeatherSensor;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.lekkss.weathersensor.weathersensorservice.*;

public class WeatherSensorClient {
    private final ManagedChannel channel;
    private final WeatherSensorServiceGrpc.WeatherSensorServiceStub stub;
    private static final String CSV_FILE_PATH = "C:\\Users\\lekkss\\Desktop\\Distributed System\\smartagriculture\\src\\main\\java\\WeatherSensor\\weather_data.csv";

    public WeatherSensorClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        this.stub = WeatherSensorServiceGrpc.newStub(channel);
    }

    public void getWeatherForecast(double latitude, double longitude) {
        LocationCoordinates locationCoordinates = LocationCoordinates.newBuilder().setLatitude(latitude)
                .setLongitude(longitude).build();
        stub.getWeatherForecast(locationCoordinates, new StreamObserver<WeatherData>() {

            @Override
            public void onNext(WeatherData weatherData) {
                System.out.println("Weather Forecast for lat: " + latitude + " , long: " + longitude);
                System.out.println("Temperature: " + weatherData.getTemperature() + "°C");
                System.out.println("Humidity: " + weatherData.getHumidity());
                System.out.println("Wind Speed: " + weatherData.getWindSpeed() + " m/s");
                System.out.println("Precipitation: " + weatherData.getPrecipitation());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in unary request: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Weather Data Suffessfully Received");
            }
        });
    }

    public void getAverageWeatherForecast() throws InterruptedException {
        try (FileReader reader = new FileReader(CSV_FILE_PATH);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            StreamObserver<WeatherData> responseObserver = new StreamObserver<WeatherData>() {
                @Override
                public void onNext(WeatherData weatherData) {
                    System.out.println("Average Weather Forecast:");
                    System.out.println("Temperature: " + weatherData.getTemperature() + "°C");
                    System.out.println("Humidity: " + weatherData.getHumidity());
                    System.out.println("Wind Speed: " + weatherData.getWindSpeed() + " m/s");
                    System.out.println("Precipitation: " + weatherData.getPrecipitation());
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Weather Forecast stream completed");
                    channel.shutdown();
                }
            };

            StreamObserver<LocationCoordinates> requestObserver = stub.getAverageWeatherForcast(responseObserver);

            for (CSVRecord csvRecord : csvParser) {
                double lat = Double.parseDouble(csvRecord.get("latitude"));
                double lng = Double.parseDouble(csvRecord.get("longitude"));

                LocationCoordinates locationCoordinates = LocationCoordinates.newBuilder().setLatitude(lat)
                        .setLongitude(lng).build();
                TimeUnit.MILLISECONDS.sleep(100);
                requestObserver.onNext(locationCoordinates);

            }

            // Indicate the end of streaming
            requestObserver.onCompleted();

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void shutdown() {
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Error while shutting down WeatherSensor client: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WeatherSensorClient client = new WeatherSensorClient("localhost", 5003);

        client.getWeatherForecast(51.5074, -0.1278);

        // client.getAverageWeatherForecast();
        // Start streaming client information
        Thread streamThread = new Thread(() -> {

            System.out.println("HERE");
            try {
                client.getAverageWeatherForecast();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        });
        streamThread.start();

        // Wait for user input to stop streaming
        System.out.println("Press 'Q' to stop streaming client information");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                streamThread.interrupt();
                break;
            }
        }
        client.shutdown();
    }
}

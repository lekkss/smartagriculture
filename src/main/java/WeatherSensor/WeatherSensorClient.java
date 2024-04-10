package WeatherSensor;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

import com.lekkss.weathersensor.weathersensorservice.*;

public class WeatherSensorClient {
    private final ManagedChannel channel;
    private final WeatherSensorServiceGrpc.WeatherSensorServiceStub stub;

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
                System.out.println("Unary request completed");
            }
        });
    }

    public void shutdown() {
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("Error while shutting down WeatherSensor client: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        WeatherSensorClient client = new WeatherSensorClient("localhost", 5003);

        client.getWeatherForecast(10.5, 20.5);
        client.shutdown();
    }
}

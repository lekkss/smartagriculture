package WeatherSensor;

import java.util.ArrayList;
import java.util.List;

import com.lekkss.weathersensor.weathersensorservice.*;

import io.grpc.stub.StreamObserver;

public class WeatherSensorImpl extends WeatherSensorServiceGrpc.WeatherSensorServiceImplBase {

    @Override
    public void getWeatherForecast(LocationCoordinates request, StreamObserver<WeatherData> responseObserver) {
        System.out.println("Data received From client " + request.getLatitude() + " " + request.getLatitude());
        WeatherData weatherData = WeatherData.newBuilder()
                .setTemperature(25.0)
                .setHumidity(0.6)
                .setWindSpeed(10.0)
                .setPrecipitation(0.1)
                .build();

        // Send the weather data back to the client
        responseObserver.onNext(weatherData);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<LocationCoordinates> getAverageWeatherForcast(StreamObserver<WeatherData> responseObserver) {
        return new StreamObserver<LocationCoordinates>() {

            List<LocationCoordinates> locationList = new ArrayList<>();

            @Override
            public void onNext(LocationCoordinates locationCoordinates) {
                locationList.add(locationCoordinates);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in client information streaming: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                double totalTemperature = 0.0;
                double totalHumidity = 0.0;
                double totalWindSpeed = 0.0;
                double totalPrecipitation = 0.0;

                for (LocationCoordinates location : locationList) {
                    // Assuming some logic to calculate weather forecast for each location
                    // For simplicity, we are using dummy values here
                    totalTemperature += 25.0;
                    totalHumidity += 0.6;
                    totalWindSpeed += 10.0;
                    totalPrecipitation += 0.1;
                }

                // Calculate average values
                double averageTemperature = totalTemperature / locationList.size();
                double averageHumidity = totalHumidity / locationList.size();
                double averageWindSpeed = totalWindSpeed / locationList.size();
                double averagePrecipitation = totalPrecipitation / locationList.size();

                WeatherData avgWeatherData = WeatherData.newBuilder().setTemperature(averageTemperature)
                        .setHumidity(averageHumidity).setPrecipitation(averagePrecipitation)
                        .setWindSpeed(averageWindSpeed).build();

                responseObserver.onNext(avgWeatherData);
                responseObserver.onCompleted();

            }
        };
    }

}

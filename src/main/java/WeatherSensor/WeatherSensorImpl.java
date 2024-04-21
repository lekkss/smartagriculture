package WeatherSensor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.lekkss.weathersensor.weathersensorservice.*;

import io.grpc.stub.StreamObserver;

public class WeatherSensorImpl extends WeatherSensorServiceGrpc.WeatherSensorServiceImplBase {
    private static final String CSV_FILE_PATH = "src/main/java/WeatherSensor/weather_data.csv";

    @Override
    public void getWeatherForecast(LocationCoordinates request, StreamObserver<WeatherData> responseObserver) {
        try {
            WeatherData weatherData = findWeatherData(request.getLatitude(), request.getLongitude());
            System.out.println("Sending weather data to client");
            responseObserver.onNext(weatherData);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    private WeatherData findWeatherData(double latitude, double longitude) throws Exception {
        try (InputStream input = new FileInputStream(CSV_FILE_PATH);
                Reader reader = new InputStreamReader(input);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord record : csvParser) {
                double lat = Double.parseDouble(record.get("latitude"));
                double lng = Double.parseDouble(record.get("longitude"));
                if (lat == latitude && lng == longitude) {
                    double temperature = Double.parseDouble(record.get("temperature"));
                    double humidity = Double.parseDouble(record.get("humidity"));
                    double windSpeed = Double.parseDouble(record.get("wind_speed"));
                    double precipitation = Double.parseDouble(record.get("precipitation"));
                    return WeatherData.newBuilder()
                            .setTemperature(temperature)
                            .setHumidity(humidity)
                            .setWindSpeed(windSpeed)
                            .setPrecipitation(precipitation)
                            .build();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    @Override
    public StreamObserver<LocationCoordinates> getAverageWeatherForcast(StreamObserver<WeatherData> responseObserver) {
        return new StreamObserver<LocationCoordinates>() {

            private final List<LocationCoordinates> locationList = new ArrayList<>();
            private double totalTemperature = 0.0;
            private double totalHumidity = 0.0;
            private double totalWindSpeed = 0.0;
            private double totalPrecipitation = 0.0;

            @Override
            public void onNext(LocationCoordinates locationCoordinates) {
                locationList.add(locationCoordinates);
                System.out.println("Received location: Latitude = " + locationCoordinates.getLatitude()
                        + ", Longitude = " + locationCoordinates.getLongitude());

                // Simulated data fetch based on coordinates
                WeatherData data = null;
                try {
                    data = findWeatherData(locationCoordinates.getLatitude(), locationCoordinates.getLongitude() );
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                assert data != null;
                totalTemperature += data.getTemperature();
                totalHumidity += data.getHumidity();
                totalWindSpeed += data.getWindSpeed();
                totalPrecipitation += data.getPrecipitation();
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in client information streaming: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                if (!locationList.isEmpty()) {
                    // Calculate average values
                    double averageTemperature = totalTemperature / locationList.size();
                    double averageHumidity = totalHumidity / locationList.size();
                    double averageWindSpeed = totalWindSpeed / locationList.size();
                    double averagePrecipitation = totalPrecipitation / locationList.size();

                    WeatherData avgWeatherData = WeatherData.newBuilder()
                            .setTemperature(averageTemperature)
                            .setHumidity(averageHumidity)
                            .setWindSpeed(averageWindSpeed)
                            .setPrecipitation(averagePrecipitation)
                            .build();

                    responseObserver.onNext(avgWeatherData);
                    responseObserver.onCompleted();
                } else {
                    responseObserver.onError(new IllegalStateException("No locations received"));
                }
            }
        };
    }



}

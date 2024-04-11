package WeatherSensor;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.lekkss.weathersensor.weathersensorservice.*;

import io.grpc.stub.StreamObserver;

public class WeatherSensorImpl extends WeatherSensorServiceGrpc.WeatherSensorServiceImplBase {
    private static final String CSV_FILE_PATH = "C:\\Users\\lekkss\\Desktop\\Distributed System\\smartagriculture\\src\\main\\java\\WeatherSensor\\weather_data.csv";

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
        Reader reader = new FileReader(CSV_FILE_PATH);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

        try {
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
        } finally {
            csvParser.close();
            reader.close();
        }

        return null;
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

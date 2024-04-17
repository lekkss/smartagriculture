package SoilSensor;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.lekkss.soilsensor.soilsensorservice.*;

import io.grpc.stub.StreamObserver;

public class SoilSensorServiceImpl extends SoilSensorServiceGrpc.SoilSensorServiceImplBase {
    // FileInputStream fileInputStream = new
    // FileInputStream("src/main/java/SoilSensor/soil_sensor_data.csv");
    private static final String CSV_FILE_PATH = "src/main/java/SoilSensor/soil_sensor_data.csv";
    private static final long STREAM_INTERVAL_MS = 2000;

    @Override
    public void getSoilData(GetSoilDataRequest request, StreamObserver<SoilData> responseObserver) {
        try {
            String time = request.getTime();
            SoilData soilData = findSoilData(time);
            responseObserver.onNext(soilData);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    private SoilData findSoilData(String time) throws Exception {
        try (InputStream input = new FileInputStream(CSV_FILE_PATH);
                Reader reader = new InputStreamReader(input);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord record : csvParser) {
                String t = record.get("Time");
                if (t.equals(time)) {
                    double temperature = Double.parseDouble(record.get("Temperature (°C)"));
                    double soilNutrients = Double.parseDouble(record.get("Soil Nutrients"));
                    double soilHumidity = Double.parseDouble(record.get("Soil Humidity"));

                    return SoilData.newBuilder()
                            .setTemperature(temperature)
                            .setSoilHumidity(soilHumidity)
                            .setSoilNutrients(soilNutrients)
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
    public void streamSoilData(StreamSoilDataRequest request, StreamObserver<SoilData> responseObserver) {
        try {
            Reader reader = new FileReader(CSV_FILE_PATH);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            for (CSVRecord record : csvParser) {
                String time = record.get("Time");
                double temperature = Double.parseDouble(record.get("Temperature (°C)"));
                double soilNutrients = Double.parseDouble(record.get("Soil Nutrients"));
                double soilHumidity = Double.parseDouble(record.get("Soil Humidity"));

                SoilData soilData = SoilData.newBuilder()
                        .setTimeOfDay(time)
                        .setTemperature(temperature)
                        .setSoilNutrients(soilNutrients)
                        .setSoilHumidity(soilHumidity)
                        .build();

                responseObserver.onNext(soilData);
                TimeUnit.MILLISECONDS.sleep(STREAM_INTERVAL_MS);
            }

            responseObserver.onCompleted();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            responseObserver.onError(e);
        }
    }

}

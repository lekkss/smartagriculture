package SoilSensor;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.lekkss.soilsensor.soilsensorservice.*;

import io.grpc.stub.StreamObserver;

public class SoilSensorServiceImpl extends SoilSensorServiceGrpc.SoilSensorServiceImplBase {
    private static final String CSV_FILE_PATH = "C:\\Users\\lekkss\\Desktop\\Distributed System\\smartagriculture\\src\\test\\java\\SoilSensor\\soil_sensor_data.csv";
    private static final long STREAM_INTERVAL_MS = 10000;

    @Override
    public void getSoilData(GetSoilDataRequest request, StreamObserver<SoilData> responseObserver) {
        SoilData soilData = SoilData.newBuilder()
                .setTemperature(25.5)
                .setSoilNutrients(0.6)
                .setSoilHumidity(0.4)
                .build();
        responseObserver.onNext(soilData);
        responseObserver.onCompleted();
    }

    @Override
    public void streamSoilData(StreamSoilDataRequest request, StreamObserver<SoilData> responseObserver)
            throws InterruptedException {
        try {
            Reader reader = new FileReader(CSV_FILE_PATH);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            for (CSVRecord record : csvParser) {
                double temperature = Double.parseDouble(record.get("Temperature (°C)"));
                double soilNutrients = Double.parseDouble(record.get("Soil Nutrients"));
                double soilHumidity = Double.parseDouble(record.get("Soil Humidity"));

                SoilData soilData = SoilData.newBuilder()
                        .setTemperature(temperature)
                        .setSoilNutrients(soilNutrients)
                        .setSoilHumidity(soilHumidity)
                        .build();

                responseObserver.onNext(soilData);
                TimeUnit.MILLISECONDS.sleep(STREAM_INTERVAL_MS);
            }

            responseObserver.onCompleted();
        } catch (IOException e) {
            e.printStackTrace();
            responseObserver.onError(e);
        }
    }

}

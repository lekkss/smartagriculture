package Irrigation;

import java.io.FileReader;
import java.io.IOException;
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
                            if (irrigationResult.getIrrigationNeeded()) {
                                System.out.println("Irrigation is Needed");
                            } else {
                                System.out.println("Irrigation not needed");
                            }
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

    public static void main(String[] args) throws InterruptedException {
        IrrigationServiceClient client = new IrrigationServiceClient("localhost", 5051);
        try {
            client.checkIrrigation(
                    "C:\\Users\\lekkss\\Desktop\\Distributed System\\smartagriculture\\src\\main\\java\\SoilSensor\\soil_sensor_data.csv");
        } finally {
            client.shutdown();
        }
    }
}

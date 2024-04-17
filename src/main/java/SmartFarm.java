import java.util.List;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.health.model.HealthService;

import Irrigation.IrrigationServiceClient;
import SoilSensor.SoilSensorServiceClient;
import javafx.scene.control.Label;

public class SmartFarm {

    private final String irrigationConsulName = "irrigation-sensor-service";
    private final String soilSensorConsulName = "soil-sensor-service";

    IrrigationServiceClient irrigationClient;
    SoilSensorServiceClient soilSensorClient;

    public SmartFarm() {
        ConsulClient consulClient = new ConsulClient("localhost", 8500);

        List<HealthService> irrigationHealthServices = consulClient.getHealthServices(irrigationConsulName, true, null)
                .getValue();
        if (irrigationHealthServices.isEmpty()) {
            System.err.println("No healthy instances of " + irrigationConsulName + " found in Consul.");
            return;
        }

        List<HealthService> soilSensorHealthServices = consulClient.getHealthServices(soilSensorConsulName, true, null)
                .getValue();
        if (soilSensorHealthServices.isEmpty()) {
            System.err.println("No healthy instances of " + soilSensorConsulName + " found in Consul.");
            return;
        }

        this.irrigationClient = new IrrigationServiceClient(irrigationHealthServices.get(0).getService().getAddress(),
                irrigationHealthServices.get(0).getService().getPort());
        this.soilSensorClient = new SoilSensorServiceClient(soilSensorHealthServices.get(0).getService().getAddress(),
                soilSensorHealthServices.get(0).getService().getPort());

        // startServer();
    }

    public void irrigateField() {
        try {
            irrigationClient.checkIrrigation("src/main/resources/consul.properties");
        } catch (InterruptedException e) {
            System.err.println("Error occurred during irrigateField(): " + e.getMessage());
        }
    }

    public void streamSoilData(Label soilDataLabel) {
        try {
            soilSensorClient.streamSoilServerRequest(soilDataLabel);
        } catch (

        Exception e) {
            System.err.println("Error occurred during streamSoilData(): " + e.getMessage());
        }
    }

    public void shutdown() {
        try {
            soilSensorClient.shutdown();
        } catch (Exception e) {
            System.err.println("Error occurred during shutdown(): " + e.getMessage());
        }
    }

    public void getSoilData(Label soilDataLabel) {
        try {
            soilSensorClient.getSoilData("06:30", soilDataLabel);
        } catch (Exception e) {
            System.err.println("Error occurred during getSoilDate(): " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new SmartFarm();
    }
}

import java.util.List;
import java.util.Scanner;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.health.model.HealthService;

import Irrigation.IrrigationServiceClient;
import SoilSensor.SoilSensorServiceClient;

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

        startServer();
    }

    public void startServer() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the FarmService command line prompt");
            System.out.println("Select an option:");
            System.out.println("1. Irrigate field");
            System.out.println("2. Stream SoilData");
            System.out.println("3. Check SoilData");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    irrigateField();
                    break;
                case 2:
                    streamSoilData();
                    break;
                case 3:
                    getSoilData();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
                    break;
            }
        }

        System.out.println("FarmService command line prompt has been terminated.");
    }

    private void irrigateField() {
        Scanner scanner = new Scanner(System.in);
        // Call irrigation service to check and perform irrigation
        try {
            irrigationClient.checkIrrigation("src/main/resources/consul.properties");
        } catch (InterruptedException e) {
            System.err.println("Error occurred during irrigation: " + e.getMessage());
        }
    }

    public void streamSoilData() {
        soilSensorClient.streamSoilServerRequest();
        try {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Press 'Q' to quit");
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("Q")) {
                    soilSensorClient.shutdown();
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error occurred during irrigation: " + e.getMessage());
        }
    }

    public void getSoilData() {
        try {
            soilSensorClient.getSoilData("06:30");
        } catch (Exception e) {
            System.err.println("Error occurred during irrigation: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new SmartFarm();
    }
}

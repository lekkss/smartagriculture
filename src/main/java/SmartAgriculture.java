import java.util.Scanner;

import Irrigation.IrrigationServiceClient;
import SoilSensor.SoilSensorServiceClient;

public class SmartAgriculture {
    private final IrrigationServiceClient irrigationClient;
    private final SoilSensorServiceClient soilSensorClient;

    public SmartAgriculture() {
        this.soilSensorClient = new SoilSensorServiceClient("localhost", 5000);
        this.irrigationClient = new IrrigationServiceClient("localhost", 5051);
    }

    public void startServer() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out
                    .println(
                            "Welcome to the FarmService command line prompt" +
                                    "\nSelect an option: " +
                                    " \n1. Irrigate field " +
                                    " \n2. Check SoilData \n3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // switch (choice) {
            // case 1:
            // irrigateField();
            // break;
            // case 2:
            // streamSoilData();
            // break;
            // case 3:
            // running = false;
            // break;
            // default:
            // System.out.println("Invalid choice. Please select again.");
            // break;
            // }

            do {
                if (choice == 1) {
                    irrigateField();
                }
                if (choice == 2) {
                    streamSoilData();
                }
                if (choice == 3) {

                } else {
                    System.out.println("Enter a valid number");
                }
            } while (choice != 3);
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
        try {
            // soilSensorClient.streamSoilServerRequest();
        } catch (Exception e) {
            System.err.println("Error occurred during irrigation: " + e.getMessage());
        }
    }

    public void getSoilData(String time) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter time to Check.");
        time = sc.nextLine();
        try {

        } catch (Exception e) {
            System.err.println("Error occurred during irrigation: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SmartAgriculture farmService = new SmartAgriculture();
        farmService.startServer();
    }
}

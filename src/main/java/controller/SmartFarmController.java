package controller;

import Irrigation.IrrigationServiceClient;
import Irrigation.IrrigationServiceServer;
import SoilSensor.SoilSensorServiceClient;
import SoilSensor.SoilSensorServiceServer;
import WeatherSensor.WeatherSensorClient;
import WeatherSensor.WeatherSensorServer;
import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.health.model.HealthService;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SmartFarmController implements ChartUpdater {
    public ToggleButton startSoilServer;
    public Button getSoilData;
    public ImageView timeIcon;
    public ImageView tempIcon;
    public ImageView humidityIcon;
    public Label timeValue;
    public Label tempValue;
    public Label humidityValue;
    public Button streamSoilDataButton;
    public ToggleButton startIrrigationSensorButton;
    public Button monitorIrrigationButton;
    public Circle irrigationSensor;
    public Label irrigationLabel;
    public LineChart<Number, Number> lineChart;
    public XYChart.Series<Number, Number> series = new XYChart.Series<>();
    public ToggleButton startWeatherSensorButton;
    public ChoiceBox setCordinate;
    public Label latitudeData;
    public Label humidityData;
    public Label windData;
    public Label presipData;
    public Label tempData;
    public Label longitudeData;
    public Button getAvgWeatherButton;
    public Label progress;

    IrrigationServiceClient irrigationClient;
    SoilSensorServiceClient soilSensorClient;
    WeatherSensorClient  weatherSensorClient;

    private List<Double> temperatureData = new ArrayList<>();
    private List<String> timeData = new ArrayList<>();

    @FXML
    public void initialize() {
        loadCoordinates();
        // Add a listener to the ChoiceBox to handle selection changes
        setCordinate.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                // Cast the selected item back to Coordinate (ensure your ChoiceBox is generically typed if using FXML)
                Coordinate selectedCoordinate = (Coordinate) newVal;
                double latitude = selectedCoordinate.getLatitude();
                double longitude = selectedCoordinate.getLongitude();
                weatherSensorClient.getWeatherForecast(latitude, longitude, latitudeData,longitudeData,tempData,humidityData,windData,presipData);
                System.out.println("Selected Latitude: " + selectedCoordinate.getLatitude() + ", Longitude: " + selectedCoordinate.getLongitude());
            }
        });
    }

    private void loadCoordinates() {
        Platform.runLater(() -> {
            try (InputStream inputStream = SmartFarmController.class.getClassLoader().getResourceAsStream("weather_data.csv")) {
                assert inputStream != null;
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                reader.readLine();
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");

                        double lat = Double.parseDouble(parts[0]);
                        double lon = Double.parseDouble(parts[1]);
                        setCordinate.getItems().add(new Coordinate(lat, lon));
                }
            } catch (IOException e) {
                System.err.println("Error reading the coordinates file: " + e.getMessage());
            }
        });
    }

    public SmartFarmController() {
        ConsulClient consulClient = new ConsulClient("localhost", 8500);

        String irrigationConsulName = "irrigation-sensor-service";
        List<HealthService> irrigationHealthServices = consulClient.getHealthServices(irrigationConsulName, true, null)
                .getValue();
        if (irrigationHealthServices.isEmpty()) {
            System.err.println("No healthy instances of " + irrigationConsulName + " found in Consul.");
            return;
        }

        String soilSensorConsulName = "soil-sensor-service";
        List<HealthService> soilSensorHealthServices = consulClient.getHealthServices(soilSensorConsulName, true, null)
                .getValue();
        if (soilSensorHealthServices.isEmpty()) {
            System.err.println("No healthy instances of " + soilSensorConsulName + " found in Consul.");
            return;
        }

        String weatherSensorConsulName = "weather-sensor-service";
        List<HealthService> weatherSensorHealthServices = consulClient.getHealthServices(weatherSensorConsulName, true, null)
                .getValue();
        if (weatherSensorHealthServices.isEmpty()) {
            System.err.println("No healthy instances of " + weatherSensorConsulName + " found in Consul.");
            return;
        }

        this.irrigationClient = new IrrigationServiceClient(irrigationHealthServices.get(0).getService().getAddress(),
                irrigationHealthServices.get(0).getService().getPort());
        this.weatherSensorClient = new WeatherSensorClient(weatherSensorHealthServices.get(0).getService().getAddress(),
                weatherSensorHealthServices.get(0).getService().getPort());
        this.soilSensorClient = new SoilSensorServiceClient(
                soilSensorHealthServices.get(0).getService().getAddress(),
                soilSensorHealthServices.get(0).getService().getPort(),
                this
        );

        Platform.runLater(() -> {
            series.setName("Temperature Over Time");
            lineChart.getData().add(series);
        });
    }

    public void stopServerAction() {
        SoilSensorServiceServer soilServer = new SoilSensorServiceServer();
        try {
            soilServer.stop();
        } catch (InterruptedException e) {
            System.err.println("Failed to stop the server: " + e.getMessage());
        }
    }


    public void startSoilServerAction(ActionEvent actionEvent) throws IOException, InterruptedException {
        SoilSensorServiceServer soilSensorServiceServer = new SoilSensorServiceServer();
        if (startSoilServer.isSelected()) {
            soilSensorServiceServer.start(5003);
            startSoilServer.setText("Stop");
            startSoilServer.setStyle("-fx-background-color: red;");
        } else {
            stopServerAction();
            startSoilServer.setText("Start");
            startSoilServer.setStyle("-fx-background-color: green;");
        }
    }

    public void getSoilDataAction(ActionEvent actionEvent) {
        TextInputDialog input = new TextInputDialog();
        input.setTitle("Time of day");
        input.setContentText("Enter your time of day");

        Optional<String> result = input.showAndWait();
        result.ifPresent(time -> {
            soilSensorClient.getSoilData(time, timeValue, tempValue, humidityValue, new Label());
            updateUIAndCheck();
        });
    }

    public void streamSoilDataAction(ActionEvent actionEvent) {
        temperatureData.clear();
        timeData.clear();
        soilSensorClient.streamSoilServerRequest(timeValue, tempValue, humidityValue, new Label(), this::updateUIAndCheck);
    } ;

    private void updateUIAndCheck() {
        Platform.runLater(() -> {
            try {
                double humidity = Double.parseDouble(humidityValue.getText().isEmpty() ? "0.0" : humidityValue.getText());
                double temperature = Double.parseDouble(tempValue.getText().isEmpty() ? "0.0" : tempValue.getText());
                check(humidity, temperature);

                // Use time labels from 0:00 to 22:00
                String[] timeLabels = {"0:00", "1:00", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00"};
                int hourIndex = Integer.parseInt(timeValue.getText().split(":")[0]);
                temperatureData.add(new XYChart.Data<>(timeLabels[hourIndex], temperature).getYValue()); // Assuming you're using XYChart.Series for temperatureData

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Failed to parse label text: " + e.getMessage());
            }
        });
    }

    public void check(double humidity, double temperature) {
        if (humidity < 0.5) {
            Image lowHumidityImage = new Image("images/low.png");
            humidityIcon.setImage(lowHumidityImage);
        } else {
            Image defaultHumidityImage = new Image("images/high.png");
            humidityIcon.setImage(defaultHumidityImage);
        }

        if (temperature > 15) {
            Image hotTemperatureImage = new Image("images/hot.png");
            tempIcon.setImage(hotTemperatureImage);
        } else {
            Image normalTemperatureImage = new Image("images/cold.png");
            tempIcon.setImage(normalTemperatureImage);
        }
    }

    public void startIrrigationSensorAction(ActionEvent actionEvent) throws IOException {
        if (startIrrigationSensorButton.isSelected()) {
            IrrigationServiceServer irrigationServiceServer = new IrrigationServiceServer();
            irrigationServiceServer.start(5001);
            startIrrigationSensorButton.setText("Stop");
            startIrrigationSensorButton.setStyle("-fx-background-color: red;");
        }
        else {
            startIrrigationSensorButton.setText("Start");
            startIrrigationSensorButton.setStyle("-fx-background-color: green;");
        }
    }

    public void monitorIrrigationAction(ActionEvent actionEvent) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                irrigationClient.checkIrrigation(irrigationLabel, irrigationSensor);
                return null;
            }
        };

        Thread thread = new Thread(task);
        thread.setDaemon(true); // Mark the thread as a daemon so it automatically terminates when the application exits
        thread.start();
    }

    @Override
    public void updateChart(String time, double temperature) {
        Platform.runLater(() -> {
            int hourOfDay = Integer.parseInt(time.split(":")[0]);
            series.getData().add(new XYChart.Data<>(hourOfDay, temperature));
        });
    }

    //WEATHER
    public void startWeatherSensorAction() throws IOException {
        if (startWeatherSensorButton.isSelected()) {
            WeatherSensorServer weatherSensorServer = new WeatherSensorServer();
            weatherSensorServer.start(5002);
            startWeatherSensorButton.setText("Stop");
            startWeatherSensorButton.setStyle("-fx-background-color: red;");
        }
      else{
            startWeatherSensorButton.setText("Start");
            startWeatherSensorButton.setStyle("-fx-background-color: green;");
        }
    }

    public void getAvgWeatherAction() throws InterruptedException {
        weatherSensorClient.getAverageWeatherForecast(progress,tempData,humidityData,windData,presipData);
    }
}

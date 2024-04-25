
Ensure that you have Maven installed and configured properly to manage the project dependencies and to build the project.

## Getting Started

smartagriculture
├── .idea                           # IDE configuration files
├── src                             # Source files
│   └── main
│       └── java
│           └── com.lekkss
│               ├── controller      # Controllers for handling HTTP requests
│               ├── Irrigation
│               │   ├── IrrigationServiceClient.java     # Client for the irrigation service
│               │   ├── IrrigationServiceServer.java     # Server for the irrigation service
│               │   └── IrrigationServiceServerImpl.java # Server implementation for the irrigation service
│               ├── SoilSensor
│               │   ├── soil_sensor_data.csv             # CSV file with soil sensor data
│               │   ├── SoilSensorServiceClient.java     # Client for the soil sensor service
│               │   ├── SoilSensorServiceImpl.java       # Service implementation for soil sensor data handling
│               │   └── SoilSensorServiceServer.java     # Server for the soil sensor service
│               └── WeatherSensor
│                   ├── weather_data.csv                 # CSV file with weather data
│                   ├── WeatherSensorClient.java         # Client for the weather sensor service
│                   ├── WeatherSensorImpl.java           # Service implementation for weather data handling
│                   └── WeatherSensorServer.java         # Server for the weather sensor service
│           ├── Launcher.java          # Main launcher for the application
│           └── SmartFarmApp.java      # Main application class
├── proto                            # Protocol buffer files for service definitions
│   ├── IrrigationService.proto
│   ├── SoilSensorService.proto
│   └── WeatherSensorService.proto
├── resources                        # Resources such as FXML layouts and properties files
│   ├── images                       # Images used in the application
│   ├── consul.properties            # Consul configuration properties
│   └── SmartFarm.fxml                # FXML layout for the smart farm application
├── target                           # Compiled code and other build artifacts
├── .gitignore                       # Specifies intentionally untracked files to ignore
└── pom.xml                          # Project Object Model for Maven


To get started with the Smart Agriculture project:

1. Clone the repository to your local machine.
2. Open the project in your IDE of choice, ensuring that it recognizes the Maven structure.
3. Install any required dependencies via Maven.
4. Configure your local development environment variables as needed.
5. Run the `Launcher.java` to start the application.

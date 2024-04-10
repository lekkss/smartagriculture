package WeatherSensor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class WeatherSensorServer {
    private Server server;

    public void start(int port) throws IOException {
        server = ServerBuilder.forPort(port).addService(new WeatherSensorImpl()).build().start();
        System.out.println("Server started. Listening on port: " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down Weather Sensor Server");
            try {
                WeatherSensorServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }));
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        WeatherSensorServer server = new WeatherSensorServer();
        server.start(5003);
        server.blockUntilShutdown();
    }
}

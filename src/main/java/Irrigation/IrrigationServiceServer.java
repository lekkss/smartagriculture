package Irrigation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class IrrigationServiceServer {
    private Server server;

    public void start(int port) throws IOException {
        server = ServerBuilder.forPort(port).addService(new IrrigationServiceServerImpl()).build().start();
        System.out.println("Server started, lisening on port " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down Irrigation Service Server");
            try {
                IrrigationServiceServer.this.stop();
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
        IrrigationServiceServer server = new IrrigationServiceServer();
        server.start(5051);
        server.blockUntilShutdown();
    }
}

package Irrigation;

import com.lekkss.irrigation.irrigationservice.*;

import io.grpc.stub.StreamObserver;

public class IrrigationServiceServerImpl extends IrrigationServiceGrpc.IrrigationServiceImplBase {
    @Override
    public StreamObserver<IrrigationSoilData> checkIrrigationNeeded(StreamObserver<IrrigationResult> responseObserver) {
        return new StreamObserver<IrrigationSoilData>() {
            @Override
            public void onNext(IrrigationSoilData soildata) {
                // check if irrigation is needed
                boolean irrigationNeeded = checkIrrigationNeededLogic(soildata);
                System.out.println("Current Humidity : " + soildata.getSoilHumidity());
                IrrigationResult result = IrrigationResult.newBuilder().setIrrigationNeeded(irrigationNeeded).build();
                responseObserver.onNext(result);
            }

            @Override
            public void onError(Throwable t) {
                // Handle error
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                // Stream completed
                System.out.println("Client stream completed");
                responseObserver.onCompleted();
            }

            // Example logic to check if irrigation is needed based on soil data
            private boolean checkIrrigationNeededLogic(IrrigationSoilData soilData) {
                // Implement your logic here
                // For example, check soil moisture level, temperature, etc.
                // Return true if irrigation is needed, false otherwise
                return soilData.getSoilHumidity() < 0.5; // Example: Irrigate if soil humidity is less than 0.5
            }
        };
    }
}

package Irrigation;

import com.lekkss.irrigation.irrigationservice.*;

import io.grpc.stub.StreamObserver;

public class IrrigationServiceServerImpl extends IrrigationServiceGrpc.IrrigationServiceImplBase {
    private boolean irrigationStatus = false;

    @Override
    public StreamObserver<IrrigationSoilData> checkIrrigationNeeded(StreamObserver<IrrigationResult> responseObserver) {
        return new StreamObserver<IrrigationSoilData>() {
            @Override
            public void onNext(IrrigationSoilData soildata) {
                // check if irrigation is needed
                boolean irrigationNeeded = checkIrrigationNeededLogic(soildata);
//                System.out.println("Current Humidity : " + soildata.getSoilHumidity());
                IrrigationResult result = IrrigationResult.newBuilder().setIrrigationNeeded(irrigationNeeded).build();


                // Toggle irrigation based on humidity
                if (irrigationNeeded && !irrigationStatus) {
                    // If irrigation is needed and it's currently off, turn it on
                    switchIrrigation(true);
                } else if (!irrigationNeeded && irrigationStatus) {
                    // If irrigation is not needed and it's currently on, turn it off
                    switchIrrigation(false);
                }
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

            private boolean checkIrrigationNeededLogic(IrrigationSoilData soilData) {
                return soilData.getSoilHumidity() < 0.5;
            }
        };
    }

    // Method to toggle irrigation on or off
    private void switchIrrigation(boolean enable) {
        if (enable) {
            System.out.println("Turning on irrigation");
            irrigationStatus = true;
        } else {
            System.out.println("Turning off irrigation");
            irrigationStatus = false;
        }
    }
}

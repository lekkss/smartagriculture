import Irrigation.IrrigationServiceServer;
import SoilSensor.SoilSensorServiceServer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class NewFile extends Application {
    public Circle sensorLight;
    SmartFarm smartFarm = new SmartFarm();
    IrrigationServiceServer irrigationServiceServer = new IrrigationServiceServer();
    public Button startIrrigationSensorButton;
    public TextFlow irrigationData;

    public Button startIrrigationServerButton;
    public Button stopIrrigationServerButton;

    public TextFlow soilDataField;
    public Button getSoilDataButton;

    public Button streamSoilDataButton;

    public Button startButton;

    public void startAction() {
        SoilSensorServiceServer myServer = new SoilSensorServiceServer();
        try {
            myServer.start(5003);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getSoilDataAction() {
        TextInputDialog input = new TextInputDialog();
        input.setTitle("WORD");
        input.setContentText("Enter your time");

        Optional<String> res = input.showAndWait();

        smartFarm = new SmartFarm();
        res.ifPresent(s -> {
            Text soilDataText = new Text();
            smartFarm.getSoilData(s, soilDataText);

            soilDataField.getChildren().clear();
            soilDataField.getChildren().add(soilDataText);
        });
    }
    public void streamSoilDataAction() {
        Text soilDataText = new Text();
        smartFarm.streamSoilData(soilDataText);

        soilDataField.getChildren().clear();
        soilDataField.getChildren().add(soilDataText);
    }

    //IRRIGATION SERVICE
    public void startIrrigationServerAction() throws IOException {
        irrigationServiceServer.start(5001);
    }

    public void stopIrrigationServerAction(ActionEvent actionEvent) {
    }

    public void startIrrigationSensorAction(ActionEvent actionEvent) {
        Text irrigationMessage = new Text();
        smartFarm.streamIrrigation(irrigationMessage, sensorLight);

        irrigationData.getChildren().clear();
        irrigationData.getChildren().add(irrigationMessage);
    }




    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NewFile.class.getResource("newFile.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 770, 620);
        primaryStage.setTitle("Smart Screen");
        primaryStage.setScene(scene);
        primaryStage.show();
    }




}

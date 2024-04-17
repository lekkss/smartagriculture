import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloWorld extends Application {
    private Label soilDataLabel;
    private SmartFarm smartFarm;

    @Override
    public void start(Stage primaryStage) {
        smartFarm = new SmartFarm();

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        VBox centerBox = new VBox(10);
        centerBox.setPadding(new Insets(10));
        centerBox.setStyle("-fx-background-color: #f0f0f0;");
        centerBox.setSpacing(20);

        Button getSoilDataButton = new Button("Get Soil Data");
        getSoilDataButton.setOnAction(event -> getSoilData());

        Button streamSoilDataButton = new Button("Stream Soil Data");
        streamSoilDataButton.setOnAction(event -> streamSoilData());

        soilDataLabel = new Label();
        soilDataLabel.setStyle("-fx-border-color: red; -fx-border-width: 2px;");

        soilDataLabel.setWrapText(true);

        centerBox.getChildren().addAll(getSoilDataButton, streamSoilDataButton, soilDataLabel);

        root.setCenter(centerBox);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Smart Farm");
        primaryStage.show();
    }

    private void getSoilData() {
        smartFarm.getSoilData(soilDataLabel);
    }

    private void streamSoilData() {
        new Thread(() -> {
            smartFarm.streamSoilData(soilDataLabel);
        }).start();
    }

    @Override
    public void stop() throws Exception {
        smartFarm.shutdown();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

import javafx.fxml.FXML;

import java.awt.*;
import java.awt.event.ActionEvent;

public class SmartFarmController {
    @FXML
    private Button startButton;

    @FXML
    private void startAction(ActionEvent event){
        System.out.println("Turning on Server");
    }


}

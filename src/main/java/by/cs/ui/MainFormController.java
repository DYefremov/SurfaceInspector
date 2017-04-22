package by.cs.ui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * @author Dmitriy V.Yefremov
 */
public class MainFormController {

    private Stage primaryStage;

    public MainFormController() {

    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    public void onExit() {
        if (primaryStage != null) {
            primaryStage.close();
            Platform.exit();
        }
    }

    @FXML
    public void initialize() {

    }
}

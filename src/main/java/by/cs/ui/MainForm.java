package by.cs.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Dmitriy V.Yefremov
 */
public class MainForm extends Application {

    private MainFormController controller;
    private Stage primaryStage;

    private final double MIN_HEIGHT = 600;
    private final double MIN_WIDTH = 800;

    @Override
    public void start(Stage primaryStage) throws IOException {

        this.primaryStage = primaryStage == null ? new Stage() : primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainForm.fxml"));
        Scene scene = new Scene(loader.load(), MIN_WIDTH, MIN_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("SurfaceInspector");
        controller = loader.getController();
        controller.setMainForm(this);
        primaryStage.show();
    }

    public void exit() {
        primaryStage.hide();
    }
}

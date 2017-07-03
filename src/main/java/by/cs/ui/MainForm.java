package by.cs.ui;

import by.cs.Service;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Dmitriy V.Yefremov
 */
public class MainForm extends Application implements Service {

    private MainFormController controller;
    private Stage primaryStage;

    private final double MIN_HEIGHT = 600;
    private final double MIN_WIDTH = 800;

    public MainForm() {
        //Trick for initialize FX Toolkit !!!
        new JFXPanel();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // !!! Keep the JavaFX runtime running in the background
        Platform.setImplicitExit(false);

        this.primaryStage = primaryStage;
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

    @Override
    public void startService() {

        Platform.runLater(() -> {
            if (primaryStage != null) {
                primaryStage.show();
            } else {
                try {
                    start(new Stage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void restartService() {

    }

    @Override
    public void stopService() {
        try {
            stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isStarted() {
        return primaryStage != null && primaryStage.isShowing();
    }
}

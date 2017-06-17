package by.cs.ui;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Optional;

/**
 * @author Dmitriy V.Yefremov
 */
public class MainFormController {

    @FXML
    private ImageView imageView;

    private Settings settings;
    private MainForm mainForm;

    public MainFormController() {

    }

    public void setMainForm(MainForm mainForm) {
        this.mainForm = mainForm;
    }

    public void onSettings() throws IOException {

        Optional<Settings> settings = new SettingsDialog().showAndWait();

        if (settings.get() != null) {
            System.out.println(settings.get());
        }
    }

    @FXML
    public void onExit() {
        mainForm.exit();
    }

    @FXML
    private void initialize() {
        settings = getCurrentSettings();
    }

    private Settings getCurrentSettings() {
        return new Settings();
    }
}

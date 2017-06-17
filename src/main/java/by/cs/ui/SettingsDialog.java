package by.cs.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Dialog;

import java.io.IOException;

/**
 * @author DMitriy V.Yefremov
 */
public class SettingsDialog extends Dialog<Settings> {

    public SettingsDialog() throws IOException {
        init();
    }


    public void init() throws IOException {
        this.setDialogPane(FXMLLoader.load(getClass().getResource("SettingsDialog.fxml")));
    }
}

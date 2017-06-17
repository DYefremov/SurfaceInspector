package by.cs;

import by.cs.ui.MainForm;
import by.cs.web.StandaloneServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Main class for initialize and starting application
 *
 * @author Dmitriy V.Yefremov
 */
public class MainService {

    private StandaloneServer server;
    private TrayIcon trayIcon;

    private static final Logger logger = LoggerFactory.getLogger(MainService.class);

    public MainService () {

    }

    public static void main(String[] args) {

        MainService service = new MainService();
        service.init();
    }

    public void init() {

        getSystemTray();
        server = StandaloneServer.getInstance();
        //Start the JavaFX ui
        MainForm.launch(MainForm.class);
    }

    /**
     * Constructing system tray
     *
     * @throws IOException
     */
    private void getSystemTray() {

        if (!SystemTray.isSupported()) {
            System.exit(0);
        }

        final SystemTray tray = SystemTray.getSystemTray();
        Image image = null;
        try {
            image = ImageIO.read(MainService.class.getResource("img/icon.png"));
        } catch (IOException e) {
            logger.error("MainService error [getSystemTray]: " + e);
        }

        trayIcon = new TrayIcon(image);
        trayIcon.setImageAutoSize(true);
        final PopupMenu menu = new PopupMenu();
        final Menu openMenuItem = new Menu("Open");
        final MenuItem openWebItem = new MenuItem("Open web");
        final MenuItem exitItem = new MenuItem("Exit");
        openMenuItem.add(openWebItem);

        openWebItem.addActionListener(e -> showWeb());
        trayIcon.addActionListener(ev -> showGui(true));
        exitItem.addActionListener(e -> {
            onExit();
            tray.remove(trayIcon);
        });

        menu.add(openMenuItem);
        menu.addSeparator();
        menu.add(exitItem);
        trayIcon.setPopupMenu(menu);
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            logger.error("MainService error [getSystemTray]: " + e);
        }
    }

    /**
     * Open page in browser
     */
    private void openUri()  {
        try {
            Desktop.getDesktop().browse(new URI("http://localhost:" + Constants.DEFAULT_PORT));
        } catch (URISyntaxException | IOException e) {
            logger.error("MainService error [openUri]: " + e);
        }
    }

    /**
     * @param show
     */
    private void showGui(boolean show) {

        if (show) {

        } else {

        }
    }

    /**
     * Starts web server and open page
     */
    private void showWeb() {

        new Thread(() -> {
            if (!server.isStarted()) {
                new Thread(() -> trayIcon.displayMessage(null, "Please wait, the web server starts!", TrayIcon.MessageType.INFO)).start();
                server.startServer();
                while (!server.isStarted()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    /**NOP*/
                }
            }
            openUri();
        }).start();
    }

    private void onExit() {

        server.stopServer();
        System.exit(0);
    }

}

package by.cs.ui;

import by.cs.cpu.Cpu;

/**
 * Class for storage and
 * working with program settings.
 *
 * @author Dmitriy V.Yefremov
 */
public class Settings {

    private Cpu cpu;
    private boolean autostart;

    public Settings() {

    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public boolean isAutostart() {
        return autostart;
    }

    public void setAutostart(boolean autostart) {
        this.autostart = autostart;
    }
}

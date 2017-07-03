package by.cs;

/**
 *@author Dmitriy V.Yefremov
 */
public interface Service {

    void startService();
    void restartService();
    void stopService();
    boolean isStarted();
}

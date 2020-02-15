package app;

import fx.display.MainWindow;

public class App implements Runnable {
    @Override
    public void run() {
        start();
        close();
    }

    private void start() {
        new MainWindow("AI and Pathfinding", 540, 480);
    }

    private void close() {

    }
}
package app;

import fx.display.MainWindow;

public class App implements Runnable {
    private boolean running = false;

    private void tick() {

    }

    private void render() {

    }

    @Override
    public void run() {
        start();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                // updates++;
                delta--;
            }
            render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(frames);
                frames = 0;
                // updates = 0;
            }
        }
        close();
    }

    private void start() {
        new MainWindow("AI and Pathfinding", 540, 480);
    }

    private void close() {

    }
}
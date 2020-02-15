package fx.display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Canvas;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    public Canvas whiteboard = new Canvas();

    public MainWindow(String title, int width, int height) {
        super(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        setup();

        // pack();
        setVisible(true);
    }

    private void setup() {
        addKeyListener(new KeyListener() {
            ConfigWindow cw = ConfigWindow.getInstance();

            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'e') {
                    cw.openConfig();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // unused
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // unused
            }
        });
    }
}
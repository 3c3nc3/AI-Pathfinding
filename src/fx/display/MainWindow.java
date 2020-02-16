package fx.display;

import java.awt.Canvas;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    public Canvas whiteboard = new Canvas();
    public JLabel focus = new JLabel();

    public MainWindow(String title, int width, int height, KeyListener keyListener) {
        super(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        addKeyListener(keyListener);
        add(focus);
        setup();
        setVisible(true);
    }

    private void setup() {
        add(whiteboard);
    }
}
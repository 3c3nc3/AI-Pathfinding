package fx.display;

import java.awt.Canvas;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    private static int width, height;
    public Canvas whiteboard = new Canvas();
    public JLabel focus = new JLabel();

    public MainWindow(String title, int width, int height, KeyListener keyListener, MouseMotionListener mouseListener) {
        super(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        addKeyListener(keyListener);
        whiteboard.addMouseMotionListener(mouseListener);
        add(focus);
        MainWindow.width = width;
        MainWindow.height = height;
        setup();
        setVisible(true);
    }

    public static Rectangle getRect() {
        return new Rectangle(width, height);
    }

    private void setup() {
        add(whiteboard);
    }
}
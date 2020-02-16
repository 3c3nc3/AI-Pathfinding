package fx.display;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

import main.Updateable;

public class ConfigWindow extends JFrame implements Updateable{
    private static final long serialVersionUID = 1L;

    private static ConfigWindow kInstance;
    private static boolean isOpen = false;

    public ConfigWindow() {
        super("Configure");
        setSize(300, 400);
        setResizable(false);
    }

    public static ConfigWindow getInstance() {
        if (kInstance == null) {
            kInstance = new ConfigWindow();
        }
        return kInstance;
    }

    public void openConfig(JComponent c) {
        setLocationRelativeTo(c);
        setVisible(true);
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public void update() {
        if (!this.isVisible()) {
            isOpen = false;
        } else {
            isOpen = true;
        }
    }

    public void render(Graphics g) {

    }
}
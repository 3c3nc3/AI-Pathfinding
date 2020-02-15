package fx.display;

import javax.swing.JFrame;

public class ConfigWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    private static ConfigWindow kInstance;

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

    public void openConfig() {
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
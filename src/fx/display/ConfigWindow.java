package fx.display;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;

import components.Player;
import components.Player.ControlMode;
import fx.assetloaders.Assets;
import main.Updateable;

public class ConfigWindow extends JFrame implements Updateable {
    private static final long serialVersionUID = 1L;

    private Assets assets = Assets.getInstance();
    private static ConfigWindow kInstance;
    private static boolean isOpen = false;

    private String playerControlModes[] = { "Keyboard", "Mouse", "Auton" };
    private JComboBox<String> playerControlMode = new JComboBox<>(playerControlModes);

    public ConfigWindow() {
        super("Configure");
        setSize(300, 400);
        setResizable(false);
        setIconImage(assets.getTexture("icon"));
        setComponents();
    }

    private void setComponents() {
        playerControlMode.setEditable(false);
        playerControlMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String) playerControlMode.getSelectedItem()) {
                    case "Keyboard":
                        Player.setControlMode(ControlMode.Keyboard);
                        return;
                    case "Mouse":
                        Player.setControlMode(ControlMode.Mouse);
                        return;
                    case "Auton":
                        Player.setControlMode(ControlMode.Auton);
                        return;
                }
            }
        });
        add(playerControlMode);
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
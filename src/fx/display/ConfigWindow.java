package fx.display;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import components.Player;
import components.Player.ControlMode;
import fx.assetloaders.Assets;
import main.Updateable;

public class ConfigWindow extends JFrame implements Updateable {
    private static final long serialVersionUID = 1L;

    private Assets assets = Assets.getInstance();
    private static ConfigWindow kInstance;
    private static boolean isOpen = false;

    private GridBagConstraints gbc = new GridBagConstraints();

    private String playerControlModes[] = { "Keyboard", "Mouse", "Auton" };
    private JComboBox<String> playerControlMode = new JComboBox<>(playerControlModes);
    private JLabel playerHeader = new JLabel("Player Controls");
    private JButton saveAndClose = new JButton("Save and Close");

    public ConfigWindow() {
        super("Configure");
        setSize(300, 400);
        setResizable(false);
        setIconImage(assets.getTexture("icon"));
        setLayout(new GridBagLayout());
        setComponents();
    }

    private void setComponents() {
        gbc.gridx = 0;
        gbc.gridy = 0;
        playerHeader.setFont(new Font("Sans", Font.BOLD, 18));
        add(playerHeader, gbc);

        gbc.gridy = 1;
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
        add(playerControlMode, gbc);

        gbc.gridy = 2;
        addSpacer();

        gbc.gridy = 3;
        saveAndClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeConfig();
            }
        });
        add(saveAndClose, gbc);
    }

    private void addSpacer() {
        add(new JLabel(" "));
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

    public void closeConfig() {
        setVisible(false);
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
package components;

import java.awt.Graphics;

import app.Keybinding;
import app.Mousebinding;
import app.util.Point;
import fx.assetloaders.Assets;
import main.Updateable;

public class Player implements Updateable {

    private Keybinding keybinding = Keybinding.getInstance();
    private Mousebinding mousebinding = Mousebinding.getInstance();
    private Assets assets = Assets.getInstance();

    private Point point = new Point(((540 / 2) - 32), ((480 / 2) - 32));;
    private ControlMode controlMode = ControlMode.Mouse;


    public int playerSpeed = 3;

    @Override
    public void update() {

        switch(controlMode) {
            case Keyboard:
                keyboardControl();
                break;
            case Mouse:
                mouseControl();
                break;
            case Auton:
                autonControl();
                break;
        }
        
        if (point.x < 0) {
            point.x = 0;
        } else if (point.x > 492) {
            point.x = 492;
        }

        if (point.y < 0) {
            point.y = 0;
        } else if (point.y > 409) {
            point.y = 409;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(assets.getTexture("player"), point.x, point.y, null);
    }

    private void keyboardControl() {
        if (keybinding.getKey("up")) {
            point.y = point.y - playerSpeed;
        }
        if (keybinding.getKey("down")) {
            point.y = point.y + playerSpeed;
        }
        if (keybinding.getKey("left")) {
            point.x = point.x - playerSpeed;
        }
        if (keybinding.getKey("right")) {
            point.x = point.x + playerSpeed;
        }
    }

    private void mouseControl() {
        point.x = mousebinding.mousePoint.x - 16;
        point.y = mousebinding.mousePoint.y - 16;
    }

    private void autonControl() {
        System.err.println("No auton controls yet... Check back later!");
    }

    public enum ControlMode {
        Auton,
        Keyboard,
        Mouse;
    }
}
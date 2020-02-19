package components;

import java.awt.Graphics;

import app.Keybinding;
import app.Mousebinding;
import app.util.Direction;
import app.util.Point;
import fx.assetloaders.Assets;
import main.Updateable;

public class Player implements Updateable {

    private Keybinding keybinding = Keybinding.getInstance();
    private static Mousebinding mousebinding = Mousebinding.getInstance();
    private Assets assets = Assets.getInstance();

    private static Point point = new Point(((540 / 2) - 32), ((480 / 2) - 32));;
    private static ControlMode controlMode = ControlMode.Keyboard;
    private Projectile projectile = new Projectile(assets.getTexture("bad-dot"), 5, 10);

    public int playerSpeed = 3;

    public Player() {
        projectile.setTermFactors(new Projectile.TermFactors(){
            public boolean factor(Projectile.ProjectileTemplate pt) {
                if (pt.x > 580 || pt.x < 0 || pt.y < 0 || pt.y > 480) {
                    return true;
                }
                return false;
            }
        });
    }

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

        projectile.update();
    }

    @Override
    public void render(Graphics g) {
        projectile.render(g);
        g.drawImage(assets.getTexture("player"), point.x, point.y, null);
    }

    private void keyboardControl() {
        if (keybinding.getKey("w")) {
            point.y = point.y - playerSpeed;
        }
        if (keybinding.getKey("s")) {
            point.y = point.y + playerSpeed;
        }
        if (keybinding.getKey("a")) {
            point.x = point.x - playerSpeed;
        }
        if (keybinding.getKey("d")) {
            point.x = point.x + playerSpeed;
        }
        if (keybinding.getKey("up")) {
            projectile.createProjectile(point.x, point.y, Direction.up);
        }
        if (keybinding.getKey("down")) {
            projectile.createProjectile(point.x, point.y, Direction.down);
        }
        if (keybinding.getKey("left")) {
            projectile.createProjectile(point.x, point.y, Direction.left);
        }
        if (keybinding.getKey("right")) {
            projectile.createProjectile(point.x, point.y, Direction.right);
        }
    }

    private void mouseControl() {
        point.x = mousebinding.mousePoint.x - 16;
        point.y = mousebinding.mousePoint.y - 16;
    }

    private void autonControl() {
        System.err.println("No auton controls yet... Check back later!");
    }

    public static void setControlMode(ControlMode cm) {
        if (cm == ControlMode.Mouse) {
            mousebinding.mousePoint.setPoint(point.x + 16, point.y + 16);
        }
        controlMode = cm; 
    }

    public enum ControlMode {
        Auton,
        Keyboard,
        Mouse;
    }
}
package components;

import java.awt.Graphics;

import app.Keybinding;
import app.util.Point;
import fx.assetloaders.Assets;
import main.Updateable;

public class Player implements Updateable {

    private Keybinding keybinding = Keybinding.getInstance();
    private Assets assets = Assets.getInstance();

    private Point point;


    public int playerSpeed = 8;

    @Override
    public void update() {
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

    @Override
    public void render(Graphics g) {
        g.drawImage(assets.getTexture("player"), point.x, point.y, null);
    }

    public Player() {
        point = new Point(((540 / 2) - 32), ((480 / 2) - 32));
    }
}
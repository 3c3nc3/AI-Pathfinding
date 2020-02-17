package components;

import java.awt.Graphics;

import app.Keybinding;
import app.util.Direction;
import app.util.Point;
import main.Updateable;

public class Player implements Updateable {

    private Keybinding keybinding = Keybinding.getInstance();

    private Point point;
    private Direction direction;

    private void handleInput() {
        
    }

    private void handleTick() {

    }

    @Override
    public void update() {
        handleInput();
        handleTick();
    }

    @Override
    public void render(Graphics g) {

    }

}
package app;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import main.Updateable;

public class Keybinding implements KeyListener, Updateable {
    private static boolean hasInstance = false;

    private boolean keys[] = new boolean[256];

    private HashMap<String, Boolean> keyValue = new HashMap<>();

    public boolean getKey(String key) {
        try {
            return keyValue.get(key);
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Keybinding createInstance() {
        if (!hasInstance) {
            hasInstance = true;
            return new Keybinding();
        } else {
            return null;
        }
    }

    private Keybinding() {
        keyValue.put("a", true);
        keyValue.put("b", false);
        keyValue.put("c", false);
        keyValue.put("d", false);
        keyValue.put("e", false);
        keyValue.put("f", false);
        keyValue.put("g", false);
        keyValue.put("h", false);
        keyValue.put("i", false);
        keyValue.put("j", false);
        keyValue.put("k", false);
        keyValue.put("l", false);
        keyValue.put("m", false);
        keyValue.put("n", false);
        keyValue.put("o", false);
        keyValue.put("p", false);
        keyValue.put("q", false);
        keyValue.put("r", false);
        keyValue.put("s", false);
        keyValue.put("t", false);
        keyValue.put("u", false);
        keyValue.put("v", false);
        keyValue.put("w", false);
        keyValue.put("x", false);
        keyValue.put("y", false);
        keyValue.put("z", false);

        keyValue.put("one", false);
        keyValue.put("two", false);
        keyValue.put("three", false);
        keyValue.put("four", false);
        keyValue.put("five", false);
        keyValue.put("six", false);
        keyValue.put("seven", false);
        keyValue.put("eight", false);
        keyValue.put("nine", false);
        keyValue.put("zero", false);

        keyValue.put("up", false);
        keyValue.put("down", false);
        keyValue.put("left", false);
        keyValue.put("right", false);
    }
    @Override
    public void update() {
        if (hasInstance) {
            keyValue.put("a", keys[KeyEvent.VK_A]);
            keyValue.put("b", keys[KeyEvent.VK_B]);
            keyValue.put("c", keys[KeyEvent.VK_C]);
            keyValue.put("d", keys[KeyEvent.VK_D]);
            keyValue.put("e", keys[KeyEvent.VK_E]);
            keyValue.put("f", keys[KeyEvent.VK_F]);
            keyValue.put("g", keys[KeyEvent.VK_G]);
            keyValue.put("h", keys[KeyEvent.VK_H]);
            keyValue.put("i", keys[KeyEvent.VK_I]);
            keyValue.put("j", keys[KeyEvent.VK_J]);
            keyValue.put("k", keys[KeyEvent.VK_K]);
            keyValue.put("l", keys[KeyEvent.VK_L]);
            keyValue.put("m", keys[KeyEvent.VK_M]);
            keyValue.put("n", keys[KeyEvent.VK_N]);
            keyValue.put("o", keys[KeyEvent.VK_O]);
            keyValue.put("p", keys[KeyEvent.VK_P]);
            keyValue.put("q", keys[KeyEvent.VK_Q]);
            keyValue.put("r", keys[KeyEvent.VK_R]);
            keyValue.put("s", keys[KeyEvent.VK_S]);
            keyValue.put("t", keys[KeyEvent.VK_T]);
            keyValue.put("u", keys[KeyEvent.VK_U]);
            keyValue.put("v", keys[KeyEvent.VK_V]);
            keyValue.put("w", keys[KeyEvent.VK_W]);
            keyValue.put("x", keys[KeyEvent.VK_X]);
            keyValue.put("y", keys[KeyEvent.VK_Y]);
            keyValue.put("z", keys[KeyEvent.VK_Z]);

            keyValue.put("one", keys[KeyEvent.VK_1]);
            keyValue.put("two", keys[KeyEvent.VK_2]);
            keyValue.put("three", keys[KeyEvent.VK_3]);
            keyValue.put("four", keys[KeyEvent.VK_4]);
            keyValue.put("five", keys[KeyEvent.VK_5]);
            keyValue.put("six", keys[KeyEvent.VK_6]);
            keyValue.put("seven", keys[KeyEvent.VK_7]);
            keyValue.put("eight", keys[KeyEvent.VK_8]);
            keyValue.put("nine", keys[KeyEvent.VK_9]);
            keyValue.put("zero", keys[KeyEvent.VK_0]);
            
            keyValue.put("up", keys[KeyEvent.VK_UP]);
            keyValue.put("down", keys[KeyEvent.VK_DOWN]);
            keyValue.put("left", keys[KeyEvent.VK_LEFT]);
            keyValue.put("right", keys[KeyEvent.VK_RIGHT]);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //unused
    }

    @Override
    public void render(Graphics g) {
        //unused
    }
}
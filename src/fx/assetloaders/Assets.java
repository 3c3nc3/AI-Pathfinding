package fx.assetloaders;

import java.awt.image.BufferedImage;

import java.util.HashMap;

public class Assets {
    private static Assets kInstance;

    private HashMap<String, BufferedImage> textures = new HashMap<>();

    public static Assets getInstance() {
        if (kInstance == null) {
            kInstance = new Assets();
        }
        return kInstance;
    }

    public BufferedImage getTexture(String name) {
        return textures.get(name);
    }

    private Assets() {
        textures.put("player", ImageLoader.loadImage("/textures/player.png/"));
    }
}
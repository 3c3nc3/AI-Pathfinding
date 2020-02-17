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
        textures.put("icon", ImageLoader.loadImage("/textures/icon.png/"));

        textures.put("player", ImageLoader.loadImage("/textures/entitys/player.png/"));
        textures.put("bad-dot", ImageLoader.loadImage("/textures/entitys/badDot.png/"));
        
        textures.put("background 1", ImageLoader.loadImage("/textures/background/background-tile1.png/"));
    }
}
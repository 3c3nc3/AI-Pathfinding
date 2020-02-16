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

    private Assets() {
        textures.put("player-mouse", ImageLoader.loadImage(""));
        textures.put("player-keyboard", ImageLoader.loadImage(""));
        textures.put("player-auto", ImageLoader.loadImage(""));
    }
}
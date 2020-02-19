package components;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import app.util.Direction;
import main.Updateable;

public class Projectile implements Updateable {
    private BufferedImage texture;
    private ArrayList<ProjectileTemplate> existingProjectiles = new ArrayList<>();

    private TermFactors termFactors;
    private long fireRate, lastFired = 0;
    private int speed = 1;
    
    public Projectile(BufferedImage texture) {
        this.texture = texture;
    }

    public Projectile(BufferedImage texture, int speed, int fireRate) {
        this.texture = texture;
        this.fireRate = fireRate;
        this.speed = speed;
    }
    
    public void createProjectile(int x, int y, Direction d) {
        if (lastFired > fireRate) {
            existingProjectiles.add(new ProjectileTemplate(x, y, d));
            lastFired = 0;
        }
    }

    public void setFirerate(int rate) {
        fireRate = rate;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setTermFactors(TermFactors tf) {
        termFactors = tf;
    }

    public void update() {
        System.out.println(existingProjectiles.size());
        ArrayList<ProjectileTemplate> termList = new ArrayList<>();
        for(ProjectileTemplate pt : existingProjectiles) {
            switch(pt.direction) {
                case up:
                    pt.y = pt.y - speed;
                    break;
                case right:
                    pt.x = pt.x + speed;
                    break;
                case down:
                    pt.y = pt.y + speed;
                    break;
                case left:
                    pt.x = pt.x - speed;
                    break;
                default:
                    System.err.println("Invalid projectile direction! How did you manage that?");
                    break;
            }
            if (termFactors.factor(pt)) {
                termList.add(pt);
            }
        }
        for(ProjectileTemplate pt : termList) {
            existingProjectiles.remove(pt);
        }
        if (lastFired < 370000) {
            lastFired++;
        }
    }
    
    public void render(Graphics g) {
        for(ProjectileTemplate pt : existingProjectiles) {
            g.drawImage(texture, pt.x, pt.y, null);
        }
    }
    
    public static class ProjectileTemplate {
        public Direction direction;
        public int x, y;
        
        public ProjectileTemplate(int startingX, int startingY, Direction d) {
            direction = d;
            x = startingX;
            y = startingY;
        }
    }

    public static interface TermFactors {
        public boolean factor(ProjectileTemplate pt);
    }
}
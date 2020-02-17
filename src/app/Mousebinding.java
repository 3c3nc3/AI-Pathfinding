package app;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import app.util.Point;

public class Mousebinding implements MouseMotionListener {
    private static Mousebinding kInstance;

    public Point mousePoint = new Point(((540 / 2) - 32), ((480 / 2) - 32));

    public static Mousebinding getInstance() {
        if (kInstance == null) {
            kInstance = new Mousebinding();
        }
        return kInstance;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        mousePoint.x = e.getX();
        mousePoint.y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
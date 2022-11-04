package Main;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public abstract class Drawable {
    protected Point location;
    protected Color color;

    public Drawable() {
        location = new Point(0, 0);
        color = Color.BLACK;
    }

    protected void draw() {
        StdDraw.line(location.x, location.y, location.x, location.y);
    }
}

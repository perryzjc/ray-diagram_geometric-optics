package Main;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public abstract class Objects {
    protected Pos loc;
    protected Color color;

    public Objects() {
        loc = new Pos(0, 0);
        color = Color.BLACK;
    }

    public Objects(Pos location, Color color) {
        this.loc = location;
        this.color = color;
    }

    /**
     * draw the object vertically to the axis
     * the pos got adjusted to the axis
     */
    protected void draw() {
        StdDraw.line(loc.drawX(), loc.drawY(), loc.drawX(), Screen.yAxis);
    }
}

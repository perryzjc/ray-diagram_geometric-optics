package Main;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public abstract class OpticalObjects {
    protected Pos loc;
    protected Color color;

    public OpticalObjects() {
        loc = new Pos(0, 0);
        color = Color.BLACK;
    }

    public OpticalObjects(Pos location, Color color) {
        this.loc = location;
        this.color = color;
    }

    /**
     * draw the object vertically to the axis
     * the pos got adjusted to the axis
     */
    protected void draw() {
        StdDraw.setPenColor(color);
        StdDraw.setPenRadius(0.010);
        StdDraw.line(loc.drawX(), loc.drawY(), loc.drawX(), Screen.yAxis);
    }
}

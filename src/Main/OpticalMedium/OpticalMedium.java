package Main.OpticalMedium;

import Main.*;
import Main.Image;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * the position of the optical medium is the position of  optical center
 */
public abstract class OpticalMedium extends OpticalObjects {
    protected double focalLength = 20;

    public OpticalMedium(Pos pos, Color color) {
        super(pos, color);
    }

    @Override
    /**
     * Draw the optical medium.
     * upside and downside are both drawn.
     */
    public void draw() {
        super.draw();
        double yOffAxis = Math.abs(loc.drawY() - Screen.yAxis);
        StdDraw.line(loc.drawX(), Screen.yAxis, loc.drawX(), Screen.yAxis - yOffAxis);
    }

    public Pos rightFocalPoint() {
        return new Pos(loc.x() + focalLength, 0);
    }

    public Pos leftFocalPoint() {
        return new Pos(loc.x() - focalLength, 0);
    }

    protected abstract Image reflect(LightingObject lightObj);
}

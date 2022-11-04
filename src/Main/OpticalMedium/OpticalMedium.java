package Main.OpticalMedium;

import Main.*;
import Main.Image;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * the position of the optical medium is the position of  optical center
 */
public abstract class OpticalMedium extends Objects {
    protected double focalLength;

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

    protected abstract Image reflect(LightingObject lightObj);
}

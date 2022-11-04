package Main.OpticalMedium;

import Main.*;
import edu.princeton.cs.algs4.StdDraw;

/**
 * the position of the optical medium is the position of  optical center
 */
public abstract class OpticalMedium extends Objects {
    protected double focalLength;

    @Override
    /**
     * Draw the optical medium.
     * upside and downside are both drawn.
     */
    public void draw() {
        draw();
        double yOffAxis = Math.abs(loc.drawY() - loc.y());
        StdDraw.line(loc.drawX(), Screen.yAxis, loc.drawX(), Screen.yAxis - yOffAxis);
    }

    protected abstract Image reflect(LightingObject lightObj);
}

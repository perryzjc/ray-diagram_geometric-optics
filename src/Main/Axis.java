package Main;

import edu.princeton.cs.algs4.StdDraw;

public class Axis extends Objects{

    /**
     * the other pos of other pos is relative to this Axis
     */
    @Override
    public void draw() {
        StdDraw.setPenRadius(0.001);
        StdDraw.setPenColor(color);
        StdDraw.line(0, Screen.yAxis, Screen.WIDTH, Screen.yAxis);
    }
}

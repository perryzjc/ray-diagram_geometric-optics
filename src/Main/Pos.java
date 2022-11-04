package Main;

public class Pos {
    private double x;
    private double y;

    /**
     * the position is compared to the axis
     */
    public Pos(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Pos add(final Pos p) {
        return new Pos(x + p.x, y + p.y);
    }

    public static double offY(Pos pos1, Pos pos2) {
        return pos2.y - pos1.y;
    }

    /**
     * @return the relative x to the axis
     */
    public double x() {
        return x;
    }

    /**
     * @return the relative y to the axis
     */
    public double y() {
        return y;
    }

    /**
     * @return the absolute x
     */
    public double drawX() {
        return x + Screen.xAxis;
    }

    /**
     * @return the absolute y
     */
    public double drawY() {
        return y + Screen.yAxis;
    }
}

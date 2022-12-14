package Main;

import Main.OpticalMedium.OpticalMedium;
import edu.princeton.cs.algs4.StdDraw;
import java.awt.*;
import java.util.ArrayList;

import java.util.List;

public class Ray {
    private Pos start;
    private Pos end;
    private double dx;
    private double dy;
    private double length;
    private int timeInterval;
    private OpticalObjects firstTouchedObj;
    private double slowScale;
    private double moveInterval;
    private double paceX;
    private double paceY;
    private boolean continuable;

    public static void main(String[] args) {
        Screen.init();
        Ray ray = new Ray(new Pos(0, 0), new Pos(0, 100));
        ray.draw(true);
    }

    public Ray(Pos start, ArrayList<OpticalObjects> objects) {
        this.start = start;
        firstTouchedObj = calcFirstTouchedObj(objects);
        if (firstTouchedObj == null) {
            continuable = false;
            return;
        }
        end = touchedPos(firstTouchedObj);
        defaultSet();
    }

    public Ray(Pos start, Pos end) {
        this.start = start;
        this.end = end;
        defaultSet();
    }

    public void defaultSet() {
        this.dx = end.x() - start.x();
        this.dy = end.y() - start.y();
        length = Math.sqrt(dx * dx + dy * dy);
        paceX = (double)Screen.WIDTH / Screen.INTERVALS;
        paceY = (double)Screen.HEIGHT / Screen.INTERVALS;
        slowScale = 3;
        setTimeInterval();
        setMoveInterval(timeInterval);
        continuable = true;
    }

    void setTimeInterval() {
        double temp = Screen.INTERVALS / length;
        if (temp < 1) {
            timeInterval = 1;
        } else {
            timeInterval = (int) temp;
        }
    }

    void setMoveInterval(double timeInterval) {
        moveInterval = length / timeInterval;
        paceX = dx / moveInterval;
        paceY = dy / moveInterval;
    }

    public double length() {
        return length;
    }

    public void draw(boolean isAnimated) {
        StdDraw.setPenColor(Color.RED);
        StdDraw.setPenRadius(0.001);
        if (isAnimated) {
            int steps = (int) moveInterval + 1;
            int actualInterval = actualInterval();
            for (int i = 0; i < steps; i++) {
                System.out.println("drawX: " + (start.x() + paceX * i) + " drawY: " + (start.y() + paceY * i));
                StdDraw.line(start.drawX(), start.drawY(), start.drawX() + paceX * i, start.drawY() + paceY * i);
                StdDraw.pause(actualInterval);
            }
        }
        drawToEnd();
    }

    private void drawToEnd() {
        StdDraw.line(start.drawX(), start.drawY(), end.drawX(), end.drawY());
    }

    private int actualInterval() {
        double temp = timeInterval * slowScale;
        if (temp == 0) {
            return 1;
        } else {
            return (int) temp;
        }
    }

    OpticalObjects calcFirstTouchedObj(ArrayList<OpticalObjects> objs) {
        //todo: currently only find the right closest obj
        for (OpticalObjects obj : objs) {
            if (obj.loc.x() > start.x() && start.y() < obj.loc.yAbs()) {
                firstTouchedObj = obj;
                return obj;
            }
        }
        return null;
    }

    Pos touchedPos(OpticalObjects obj) {
        //todo: currently only find the horizontally pos of the obj
        return new Pos(obj.loc.x(), start.y());
    }

    public LightingObject formNewObject() {
        //todo: currently only return a new object at right side of the first touched optical medium
        if (firstTouchedObj == null) {
            return null;
        }
        if (!(firstTouchedObj instanceof OpticalMedium)) {
            return null;
        }
        OpticalMedium medium = (OpticalMedium) firstTouchedObj;
        Pos touchedPos = touchedPos(medium);
        Ray ray1 = new Ray(touchedPos, medium.rightFocalPoint());
        Ray ray2 = new Ray(start, medium.origin());
        ray1.draw(true);
        ray2.draw(true);
        Pos intersection = extend2RaysToFindIntersection(ray1, ray2);
        Ray ray3 = new Ray(ray1.end, intersection);
        Ray ray4 = new Ray(ray2.end, intersection);
        ray3.draw(true);
        ray4.draw(true);

        return new LightingObject(intersection, Color.orange);
    }

    /**
     * 3 cases:
     * 1. extend to find a pos for real image
     * 2. reversely extend to find a pos for virtual image
     * 3. two rays are parallel, can not find its intersection
     */
    public Pos extend2RaysToFindIntersection(Ray ray1, Ray ray2) {
        double k1 = ray1.dy / ray1.dx;
        double k2 = ray2.dy / ray2.dx;
        if (Math.abs(k1 - k2) < 0.0001) {
            return null;
        }
        double x = (k1 * ray1.start.x() - k2 * ray2.start.x() + ray2.start.y() - ray1.start.y()) / (k1 - k2);
        double y = k1 * (x - ray1.start.x()) + ray1.start.y();
        return new Pos(x, y);
    }

    public double dx() {
        return dx;
    }

    public double dy() {
        return dy;
    }

    public boolean continuable() {
        return continuable;
    }
}

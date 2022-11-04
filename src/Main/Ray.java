package Main;

import edu.princeton.cs.algs4.StdDraw;
import java.awt.*;

public class Ray {
    private Point start;
    private Point end;
    private double dx;
    private double dy;
    private double length;
    private int timeInterval;
    private double moveInterval;
    private double paceX;
    private double paceY;

    public static void main(String[] args) {
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(0, 500);
        StdDraw.setYscale(0, 500);
        Ray ray = new Ray(new Point(0, 0), new Point(400, 400));
        ray.draw(true);
    }

    public Ray(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.dx = end.getX() - start.getX();
        this.dy = end.getY() - start.getY();
        length = Math.sqrt(dx * dx + dy * dy);
        paceX = Screen.WIDTH / Screen.INTERVALS;
        paceY = Screen.HEIGHT / Screen.INTERVALS;
        setTimeInterval();
        setMoveInterval(timeInterval);
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
        StdDraw.setPenRadius(0.005);
        if (isAnimated) {
            int steps = (int) moveInterval;
            for (int i = 0; i < steps; i++) {
                System.out.println("current x: " + start.getX() + paceX * i);
                System.out.println("current y: " + start.getY() + paceY * i);
                StdDraw.line(start.getX(), start.getY(), start.getX() + paceX * i, start.getY() + paceY * i);
                StdDraw.pause(timeInterval);
            }
        } else {
            StdDraw.line(start.x, start.y, end.x, end.y);
        }
    }
}

package Main;

import edu.princeton.cs.algs4.StdDraw;
import java.awt.*;

public class Ray {
    private Pos start;
    private Pos end;
    private double dx;
    private double dy;
    private double length;
    private int timeInterval;
    private double slowScale;
    private double moveInterval;
    private double paceX;
    private double paceY;

    public static void main(String[] args) {
        Screen.init();
        Ray ray = new Ray(new Pos(0, 0), new Pos(0, 100));
        ray.draw(true);
    }

    public Ray(Pos start, Pos end) {
        this.start = start;
        this.end = end;
        this.dx = end.x() - start.x();
        this.dy = end.y() - start.y();
        length = Math.sqrt(dx * dx + dy * dy);
        paceX = Screen.WIDTH / Screen.INTERVALS;
        paceY = Screen.HEIGHT / Screen.INTERVALS;
        slowScale = 3;
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
        StdDraw.setPenRadius(0.002);
        if (isAnimated) {
            int steps = (int) moveInterval;
            int actualInterval = actualInterval();
            for (int i = 0; i < steps + 1; i++) {
                System.out.println("drawX: " + (start.x() + paceX * i) + " drawY: " + (start.y() + paceY * i));
                StdDraw.line(start.drawX(), start.drawY(), start.drawX() + paceX * i, start.drawY() + paceY * i);
                StdDraw.pause(actualInterval);
            }
        } else {
            StdDraw.line(start.drawX(), start.drawY(), end.drawX(), end.drawY());
        }
    }

    private int actualInterval() {
        double temp = timeInterval * slowScale;
        if (temp == 0) {
            return 1;
        } else {
            return (int) temp;
        }
    }
}

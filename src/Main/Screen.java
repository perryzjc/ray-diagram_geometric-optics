package Main;

import Main.OpticalMedium.Lens.ConcaveLens;
import Main.OpticalMedium.Lens.ConvexLens;
import Main.OpticalMedium.Lens.PlaneLens;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.ArrayList;

public class Screen {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int INTERVALS = 1000;
    public static final double xAxis = (double) WIDTH / 2;
    public static final double yAxis = (double) HEIGHT / 3;
    public static final Pos offPosOfAxis = new Pos(0, Screen.yAxis);
    private ArrayList<Objects> objects;

    public static void init() {
        StdDraw.setCanvasSize(Screen.WIDTH, Screen.HEIGHT);
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);
    }

    public static void main(String[] args) {
        Screen.init();
        Screen screen = new Screen();
        Objects obj = new ConcaveLens(new Pos(0, 80));
        Objects obj2 = new ConvexLens(new Pos(50, 50));
        Objects obj3 = new LightingObject(new Pos(-50, 20), Color.MAGENTA);
        screen.add(obj);
        screen.add(obj2);
        screen.add(obj3);
        screen.run();
    }

    public Screen() {
        objects = new ArrayList<>();
        objects.add(new Axis());
    }

    public void add(Objects obj) {
        objects.add(obj);
        objects.sort((o1, o2) -> {
            if (o1.loc.x() > o2.loc.x()) {
                return 1;
            } else if (o1.loc.x() < o2.loc.x()) {
                return -1;
            } else {
                return 0;
            }
        });
    }

    public void run() {
        for (Objects obj : objects) {
            obj.draw();
        }
        activateRays();
    }

    public void activateRays() {
        for (Objects obj : objects) {
            if (obj instanceof LightingObject) {
                ((LightingObject) obj).sendRay(objects);
            }
        }
    }
}

package Main;

import java.util.ArrayList;

public class Screen {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int INTERVALS = 1000;
    public static final double xAxis = (double) WIDTH / 2;
    public static final double yAxis = (double) HEIGHT / 3;
    public static final Pos offPosOfAxis = new Pos(0, Screen.yAxis);
    private ArrayList<Objects> objects;

    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.run();
    }

    public void put(Objects obj) {
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
    }
}

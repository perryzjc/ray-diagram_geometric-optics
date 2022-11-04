package Main;

import Main.OpticalMedium.*;
import Main.OpticalMedium.Mirror.Mirror;

import java.util.ArrayList;

public class Screen {
    public static final double WIDTH = 800;
    public static final double HEIGHT = 600;
    public static final int INTERVALS = 1000;
    private ArrayList<Drawable> objects;

    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.run();
    }

    public void put(Drawable obj) {
        objects.add(obj);
        objects.sort((o1, o2) -> {
            if (o1.location.x > o2.location.x) {
                return 1;
            } else if (o1.location.x < o2.location.x) {
                return -1;
            } else {
                return 0;
            }
        });
    }

    public void run() {
        for (Drawable obj : objects) {
            obj.draw();
        }
    }
}

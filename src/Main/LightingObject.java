package Main;

import java.awt.*;
import java.util.List;

public class LightingObject extends Objects {
    public LightingObject(Pos location, Color color) {
        super(location, color);
    }

    @Override
    public void draw() {
        super.draw();
    }

    public void sendRay(List<Objects> objects) {
        Ray ray = new Ray(loc, objects);
        ray.draw(true);
    }
}

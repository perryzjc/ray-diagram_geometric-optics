package Main;

import java.awt.*;

public class LightingObject extends OpticalObjects {
    public LightingObject(Pos location, Color color) {
        super(location, color);
    }

    @Override
    public void draw() {
        super.draw();
    }

    public void sendRay() {
        Ray ray = new Ray(loc, loc.add(new Pos(100, 0)));
        ray.draw(true);
    }
}

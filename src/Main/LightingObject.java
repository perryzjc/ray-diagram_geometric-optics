package Main;

import java.awt.*;
import java.util.ArrayList;

public class LightingObject extends OpticalObjects {
    public LightingObject(Pos location, Color color) {
        super(location, color);
    }

    @Override
    public void draw() {
        super.draw();
    }

    public void sendRay(ArrayList<OpticalObjects> objects) {
        Ray ray = new Ray(loc, objects);
        if (!ray.continuable()) {
            return;
        }
        ray.draw(true);
        LightingObject newObj = ray.formNewObject();
        if (newObj != null) {
            newObj.sendRay(objects);
        }
    }
}

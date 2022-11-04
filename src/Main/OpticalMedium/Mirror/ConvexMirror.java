package Main.OpticalMedium.Mirror;

import Main.Image;
import Main.LightingObject;
import Main.Pos;

import java.awt.*;

public class ConvexMirror extends Mirror {

    public ConvexMirror(Pos pos, Color color) {
        super(pos, color);
    }

    @Override
    protected Image reflect(LightingObject lightObj) {
        return null;
    }
}

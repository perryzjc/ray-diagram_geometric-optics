package Main.OpticalMedium.Lens;

import Main.Image;
import Main.LightingObject;
import Main.Pos;

import java.awt.*;

public class ConvexLens extends Lens {

    public ConvexLens(Pos pos) {
        super(pos, Color.CYAN);
    }

    @Override
    protected Image reflect(LightingObject lightObj) {
        return null;
    }
}

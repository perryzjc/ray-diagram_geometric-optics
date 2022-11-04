package Main.OpticalMedium.Lens;

import Main.Image;
import Main.LightingObject;
import Main.Pos;

import java.awt.*;

public class PlaneLens extends Lens {
    public PlaneLens(Pos pos) {
        super(pos, Color.green);
    }

    @Override
    protected Image reflect(LightingObject lightObj) {
        return null;
    }
}

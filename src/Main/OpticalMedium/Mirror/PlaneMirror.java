package Main.OpticalMedium.Mirror;

import Main.Image;
import Main.LightingObject;
import Main.Pos;

import java.awt.*;

public class PlaneMirror extends Mirror {

    public PlaneMirror(Pos pos, Color color) {
        super(pos, color);
    }

    @Override
    protected Image reflect(LightingObject lightObj) {
        return null;
    }
}

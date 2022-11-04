package Main.OpticalMedium.Lens;

import Main.Image;
import Main.LightingObject;
import Main.Pos;

import java.awt.*;

public class ConcaveLens extends Lens {
    public ConcaveLens(Pos pos) {
        super(pos, Color.BLUE);
    }

    @Override
    protected Image reflect(LightingObject lightObj) {
        return null;
    }
}

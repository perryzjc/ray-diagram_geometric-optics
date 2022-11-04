package Main.OpticalMedium.Mirror;

import Main.Image;
import Main.LightingObject;
import Main.Pos;

import java.awt.*;

public class ConcaveMirror extends Mirror {
    public ConcaveMirror(Pos pos, Color color) {
        super(pos, color);
    }

    @Override
    protected Image reflect(LightingObject lightObj) {
        return null;
    }
}

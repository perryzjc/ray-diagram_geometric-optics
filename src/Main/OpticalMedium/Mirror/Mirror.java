package Main.OpticalMedium.Mirror;

import Main.OpticalMedium.OpticalMedium;
import Main.Pos;

import java.awt.*;

public abstract class Mirror extends OpticalMedium {

    public Mirror(Pos pos, Color color) {
        super(pos, color);
    }
}

package Main.OpticalMedium.Lens;
import Main.OpticalMedium.OpticalMedium;
import Main.Pos;

import java.awt.*;

public abstract class Lens extends OpticalMedium {
    public Lens(Pos pos, Color color) {
        super(pos, color);
    }
}

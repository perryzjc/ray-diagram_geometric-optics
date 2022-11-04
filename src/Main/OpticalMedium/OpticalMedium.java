package Main.OpticalMedium;

import Main.Image;
import Main.LightingObject;
import Main.Drawable;

public abstract class OpticalMedium extends Drawable {
    protected double focalLength;
    protected double offXofOpticalCenter;
    protected double offYofOpticalCenter;

    protected abstract Image reflect(LightingObject lightObj);
}

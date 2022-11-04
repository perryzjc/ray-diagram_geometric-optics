package Main.OpticalMedium;

import Main.Image;
import Main.LightingObject;

public abstract class OpticalMedium {
    protected double focalLength;
    protected double offXofOpticalCenter;
    protected double offYofOpticalCenter;

    protected abstract Image reflect(LightingObject lightObj);
}

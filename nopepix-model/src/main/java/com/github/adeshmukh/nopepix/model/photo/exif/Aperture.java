package com.github.adeshmukh.nopepix.model.photo.exif;

import static com.google.common.base.Objects.equal;

import com.google.common.base.Objects;

public class Aperture {
    private double fNumber;
    private double maxApertureValue;
    public double getfNumber() {
        return fNumber;
    }
    public double getMaxApertureValue() {
        return maxApertureValue;
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof Aperture) {
            Aperture that = (Aperture) other;
            return equal(fNumber, that.fNumber) && equal(maxApertureValue, that.maxApertureValue);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(fNumber, maxApertureValue);
    }
}

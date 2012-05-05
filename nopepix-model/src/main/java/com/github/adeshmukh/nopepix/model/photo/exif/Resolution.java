package com.github.adeshmukh.nopepix.model.photo.exif;

import static com.google.common.base.Objects.equal;

import com.google.common.base.Objects;

public class Resolution {

    private int x;
    private int y;
    private ResolutionUnit unit;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public ResolutionUnit getUnit() {
        return unit;
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof Resolution) {
            Resolution that = (Resolution) other;
            return equal(x, that.x) && equal(y, that.y) && equal(unit, that.unit);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(x, y, unit);
    }
}

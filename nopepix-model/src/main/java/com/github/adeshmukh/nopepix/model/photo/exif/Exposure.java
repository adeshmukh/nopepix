package com.github.adeshmukh.nopepix.model.photo.exif;

import static com.google.common.base.Objects.equal;

import com.google.common.base.Objects;

public class Exposure {
    private long timeNanos;
    private double bias;
    @Override
    public boolean equals(Object other) {
        if (other instanceof Exposure) {
            Exposure that = (Exposure) other;
            return equal(timeNanos, that.timeNanos) && equal(bias, that.bias);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(timeNanos, bias);
    }
}

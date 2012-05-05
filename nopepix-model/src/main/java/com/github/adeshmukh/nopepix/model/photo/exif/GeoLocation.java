package com.github.adeshmukh.nopepix.model.photo.exif;

import static com.google.common.base.Objects.equal;

import com.google.common.base.Objects;

public class GeoLocation {

    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof GeoLocation) {
            GeoLocation that = (GeoLocation) other;
            return equal(latitude, that.latitude) && equal(longitude, that.longitude);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(latitude, longitude);
    }
}

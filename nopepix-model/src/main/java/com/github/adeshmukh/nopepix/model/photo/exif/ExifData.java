package com.github.adeshmukh.nopepix.model.photo.exif;

import java.util.Map;

import org.joda.time.LocalDateTime;


public class ExifData {

    private String exifVersion;
    private GeoLocation geo;
    private LocalDateTime dateTime;
    private Resolution resolution;
    private Exposure exposure;
    private Aperture aperture;
    private boolean flash;
    private double focalLength;
    private Map<String, String> misc;

    public String getExifVersion() {
        return exifVersion;
    }
    public GeoLocation getGeo() {
        return geo;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public Resolution getResolution() {
        return resolution;
    }
    public Exposure getExposure() {
        return exposure;
    }
    public Aperture getAperture() {
        return aperture;
    }
    public boolean isFlash() {
        return flash;
    }
    public double getFocalLength() {
        return focalLength;
    }
    public Map<String, String> getMisc() {
        return misc;
    }
    
}

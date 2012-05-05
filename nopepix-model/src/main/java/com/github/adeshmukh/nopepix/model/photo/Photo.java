package com.github.adeshmukh.nopepix.model.photo;

import java.util.Collections;
import java.util.Set;

import com.github.adeshmukh.nopepix.model.photo.exif.ExifData;

public class Photo {

    private String contentHash;

    private String name;
    private String description;
    private int height;
    private int width;
    private Orientation orientation;
    private int rating;
    private int numLikes;
    private boolean published;
    private Set<User> viewAcl = Collections.emptySet();
    private User owner;
    private ExifData exif;

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public Orientation getOrientation() {
        return orientation;
    }
    public int getRating() {
        return rating;
    }
    public int getNumLikes() {
        return numLikes;
    }
    public String getContentHash() {
        return contentHash;
    }
    public boolean isPublished() {
        return published;
    }
    public boolean isPublic() {
        return viewAcl.isEmpty();
    }
    public Set<User> getViewAcl() {
        return viewAcl;
    }
    public User getOwner() {
        return owner;
    }
    public ExifData getExif() {
        return exif;
    }
}

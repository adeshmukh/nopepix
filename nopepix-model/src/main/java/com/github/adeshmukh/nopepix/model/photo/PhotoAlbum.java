package com.github.adeshmukh.nopepix.model.photo;

import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.LocalDateTime;

public class PhotoAlbum {

    @JsonIgnore
    private String id;

    private String name;
    private String description;
    private LocalDateTime created = new LocalDateTime();
    private LocalDateTime modified = new LocalDateTime();
    private List<Photo> photos = Collections.emptyList();
    private Photo coverPhoto;
    private boolean autoPublish;
    private boolean published;
    private List<String> acl;
    private String ownerId;
    void setId(String id) {
        this.id = id;
    }
    public void setOwnerId(String id) {
        ownerId = id;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public LocalDateTime getCreated() {
        return created;
    }
    public LocalDateTime getModified() {
        return modified;
    }
    public List<Photo> getPhotos() {
        return photos;
    }
    public Photo getCoverPhoto() {
        return coverPhoto;
    }
    public boolean isAutoPublish() {
        return autoPublish;
    }
    public boolean isPublished() {
        return published;
    }
    public List<String> getAcl() {
        return acl;
    }
    public String getOwnerId() {
        return ownerId;
    }
}

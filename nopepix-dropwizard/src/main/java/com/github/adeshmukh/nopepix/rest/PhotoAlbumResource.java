package com.github.adeshmukh.nopepix.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.adeshmukh.nopepix.model.photo.PhotoAlbum;
import com.github.adeshmukh.nopepix.service.PhotoService;
import com.yammer.metrics.annotation.Timed;

@Path("/user/{userId}/album")
@Produces(MediaType.APPLICATION_JSON)
public class PhotoAlbumResource {

    private PhotoService photoService;
    
    @Inject
    public PhotoAlbumResource(PhotoService photoService) {
        this.photoService = photoService;
    }
    
    @GET
    @Timed
    public List<PhotoAlbum> getAlbums(@PathParam("userId") String userId) {
        // TODO: validation and error codes
        // TODO: inject current user via security context
        return photoService.getPhotoAlbumsOwnedBy(userId);
    }
}

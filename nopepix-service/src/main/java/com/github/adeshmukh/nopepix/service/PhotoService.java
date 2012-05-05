package com.github.adeshmukh.nopepix.service;

import java.util.List;

import com.github.adeshmukh.nopepix.db.mongo.PhotoAlbumRepository;
import com.github.adeshmukh.nopepix.model.photo.Photo;
import com.github.adeshmukh.nopepix.model.photo.PhotoAlbum;
import com.github.adeshmukh.nopepix.model.photo.User;

public class PhotoService {

    private PhotoAlbumRepository repo;
    
    public PhotoService(PhotoAlbumRepository photoAlbumRepo) {
        this.repo = photoAlbumRepo;
    }

    public List<PhotoAlbum> getPhotoAlbumsOwnedBy(String userId) {
        return repo.findByOwnerId(userId);
    }
    
    public PhotoAlbum getPhotoAlbum(String ownerId, String photoAlbumId) {
        return repo.findByOwnerIdAndId(ownerId, photoAlbumId);
    }
    
    // TODO adeshmukh: optimize the delete to avoid fetch
    public void deletePhotoAlbum(String ownerId, String photoAlbumId) {
        PhotoAlbum photoAlbum = getPhotoAlbum(ownerId, photoAlbumId);
        if (photoAlbum != null) {
            repo.delete(photoAlbumId);
        }
    }
    
    public PhotoAlbum addPhotoAlbum(User user, PhotoAlbum album) {
        album.setOwnerId(user.getId());
        return repo.save(album);
    }
    
    public void updatePhotoAlbum(User user, PhotoAlbum album) {
        // validate what fields are allowed to be updated
    }
    
    public int addPhotos(User user, String photoAlbumId, List<Photo> photos) {
        // validate photos.size()
        return 0;
    }
    
}

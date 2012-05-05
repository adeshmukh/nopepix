package com.github.adeshmukh.nopepix.db.mongo;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.adeshmukh.nopepix.model.photo.PhotoAlbum;

public interface PhotoAlbumRepository extends PagingAndSortingRepository<PhotoAlbum, String> {

    public List<PhotoAlbum> findByOwnerId(String ownerId);
    
    public PhotoAlbum findByOwnerIdAndId(String ownerId, String photoAlbumId);
    
    
  //  public List<PhotoAlbum> findByPhoto_MaxSizeBounds();
    
//    public List<PhotoAlbum> findBy();
}

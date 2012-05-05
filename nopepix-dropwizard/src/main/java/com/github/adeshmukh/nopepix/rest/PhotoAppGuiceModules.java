package com.github.adeshmukh.nopepix.rest;

import java.util.Iterator;

import javax.inject.Inject;

import com.github.adeshmukh.nopepix.service.PhotoService;
import com.github.adeshmukh.nopepix.service.ServiceGuiceModules;
import com.github.adeshmukh.nopepix.service.UserService;
import com.google.common.collect.ImmutableList;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.Provides;

public class PhotoAppGuiceModules implements Iterable<Module> {

    public class PhotoAppGuiceModule extends AbstractModule {

        @Override
        protected void configure() {
        }
        
        @Inject
        @Provides
        public PhotoAlbumResource photoAlbumResource(PhotoService photoService) {
            return new PhotoAlbumResource(photoService);
        }
        
        @Inject
        @Provides
        public UserResource userResource(UserService userService) {
            return new UserResource(userService);
        }
    }

    @Override
    public Iterator<Module> iterator() {
        return ImmutableList.<Module> builder()
                .addAll(new ServiceGuiceModules())
                .add(new PhotoAppGuiceModule())
                .build()
                .iterator();
    }

}

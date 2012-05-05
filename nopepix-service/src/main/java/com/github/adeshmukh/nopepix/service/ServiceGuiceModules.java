package com.github.adeshmukh.nopepix.service;

import java.util.Iterator;

import javax.inject.Inject;

import com.github.adeshmukh.nopepix.db.mongo.DbGuiceModules;
import com.github.adeshmukh.nopepix.db.mongo.PhotoAlbumRepository;
import com.github.adeshmukh.nopepix.db.mongo.UserRepository;
import com.google.common.collect.ImmutableList;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.Provides;

public class ServiceGuiceModules implements Iterable<Module> {

    public class ServiceGuiceModule extends AbstractModule {
        @Override
        protected void configure() {
        }
        
        @Inject
        @Provides
        public PhotoService photoService(PhotoAlbumRepository photoAlbumRepo) {
            return new PhotoService(photoAlbumRepo);
        }
        
        @Inject
        @Provides
        public UserService userService(UserRepository userRepository) {
            return new UserService(userRepository);
        }
    }

    @Override
    public Iterator<Module> iterator() {
        return ImmutableList.<Module> builder()
                .addAll(new DbGuiceModules())
                .add(new ServiceGuiceModule())
                .build()
                .iterator();
    }
}

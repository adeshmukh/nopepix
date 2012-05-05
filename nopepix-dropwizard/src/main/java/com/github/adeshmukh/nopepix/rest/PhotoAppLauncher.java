package com.github.adeshmukh.nopepix.rest;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;

public class PhotoAppLauncher extends Service<PhotoConfiguration> {

    private PhotoAlbumResource photoAlbumResource;
    private UserResource userResource;
    
    public PhotoAppLauncher() {
        super("photo-service");
    }
    
    @Override
    protected void initialize(PhotoConfiguration config, Environment env) throws Exception {
        injectDependencies();
        env.addResource(photoAlbumResource);
        env.addResource(userResource);
    }

    private void injectDependencies() {
        Injector injector = Guice.createInjector(new PhotoAppGuiceModules());
        photoAlbumResource = injector.getInstance(PhotoAlbumResource.class);
        userResource = injector.getInstance(UserResource.class);
    }

    public static void main(String[] args) throws Exception {
        new PhotoAppLauncher().run(args);
    }
}

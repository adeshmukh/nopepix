package com.github.adeshmukh.nopepix.db.mongo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

import javax.inject.Inject;

import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoExceptionTranslator;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoOptionsFactoryBean;

import com.google.common.collect.ImmutableList;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import com.mongodb.Mongo;

public class DbGuiceModules implements Iterable<Module> {

    @Override
    public Iterator<Module> iterator() {
        return ImmutableList.<Module> of(new DbGuiceModule()).iterator();
    }

    public class DbGuiceModule extends AbstractModule {
        
        @Override
        protected void configure() {
            try {
                Properties properties = new Properties();
                InputStream propsStream = getClass().getClassLoader().getResourceAsStream("mongodb.properties");
                properties.load(propsStream);
                Names.bindProperties(binder(), properties);
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
        }

        @Provides
        public DbProperties dbProperties() {
            return new DbProperties();
        }
        
        @Inject
        @Provides
        public DbConfigurer dbConfigurer(DbProperties dbProps) {
            return new DbConfigurer(dbProps);
        }
        
        @Inject
        @Provides
        public PhotoAlbumRepository getPhotoAlbumRepository(DbConfigurer dbConfigurer) {
            return dbConfigurer.getPhotoAlbumRepository();
        }
        
        @Inject
        @Provides
        public UserRepository userRepository(DbConfigurer dbConfigurer) {
            return dbConfigurer.userRepository();
        }
        
        @Inject
        @Provides
        public MongoOperations mongoOperations(DbConfigurer dbConfigurer, MongoDbFactory mongoDbFactory) {
            return dbConfigurer.mongoOperations(mongoDbFactory);
        }

        @Inject
        @Provides
        public MongoDbFactory mongoDbFactory(DbConfigurer dbConfigurer, Mongo mongo) {
            return dbConfigurer.mongoDbFactory(mongo);
        }

        @Inject
        @Provides
        public Mongo mongo(DbConfigurer dbConfigurer, MongoOptionsFactoryBean mofb) {
            return dbConfigurer.mongo(mofb);
        }

        @Inject
        @Provides
        public MongoOptionsFactoryBean mongoOptionsFactoryBean(DbConfigurer dbConfigurer) {
            return dbConfigurer.mongoOptionsFactoryBean();
        }

        @Inject
        @Provides
        public MongoExceptionTranslator mongoExceptionTranslator(DbConfigurer dbConfigurer) {
            return dbConfigurer.mongoExceptionTranslator();
        }

        @Inject
        @Provides
        public PersistenceExceptionTranslationPostProcessor exceptionTranslatorBootstrap(DbConfigurer dbConfigurer) {
            return dbConfigurer.exceptionTranslatorBootstrap();
        }
    }
}

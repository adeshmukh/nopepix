package com.github.adeshmukh.nopepix.db.mongo;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoExceptionTranslator;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoOptionsFactoryBean;

import com.mongodb.Mongo;

@Configuration
public class DbSpringConfiguration {
    
    @Bean
    public DbProperties dbProperties() {
        return new DbProperties();
    }
    
    @Inject
    @Bean
    public DbConfigurer dbConfigurer(DbProperties dbProps) {
        return new DbConfigurer(dbProps);
    }
    
    @Inject
    @Bean
    public PhotoAlbumRepository getPhotoAlbumRepository(DbConfigurer dbConfigurer) {
        return dbConfigurer.getPhotoAlbumRepository();
    }
    
    @Inject
    @Bean
    public UserRepository userRepository(DbConfigurer dbConfigurer) {
        return dbConfigurer.userRepository();
    }
    
    @Inject
    @Bean
    public MongoOperations mongoOperations(DbConfigurer dbConfigurer, MongoDbFactory mongoDbFactory) {
        return dbConfigurer.mongoOperations(mongoDbFactory);
    }

    @Inject
    @Bean
    public MongoDbFactory mongoDbFactory(DbConfigurer dbConfigurer, Mongo mongo) {
        return dbConfigurer.mongoDbFactory(mongo);
    }

    @Inject
    @Bean
    public Mongo mongo(DbConfigurer dbConfigurer, MongoOptionsFactoryBean mofb) {
        return dbConfigurer.mongo(mofb);
    }

    @Inject
    @Bean
    public MongoOptionsFactoryBean mongoOptionsFactoryBean(DbConfigurer dbConfigurer) {
        return dbConfigurer.mongoOptionsFactoryBean();
    }

    @Inject
    @Bean
    public MongoExceptionTranslator mongoExceptionTranslator(DbConfigurer dbConfigurer) {
        return dbConfigurer.mongoExceptionTranslator();
    }

    @Inject
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslatorBootstrap(DbConfigurer dbConfigurer) {
        return dbConfigurer.exceptionTranslatorBootstrap();
    }
}

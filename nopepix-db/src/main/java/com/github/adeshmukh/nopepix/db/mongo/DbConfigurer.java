package com.github.adeshmukh.nopepix.db.mongo;

import static com.google.common.base.Preconditions.checkArgument;

import java.io.Serializable;
import java.net.UnknownHostException;

import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoExceptionTranslator;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoOptionsFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactoryBean;
import org.springframework.data.repository.Repository;

import com.mongodb.Mongo;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

public class DbConfigurer {
    
    private DbProperties dbp;
    
    public DbConfigurer(DbProperties dbProps) {
        checkArgument(dbProps != null);
        this.dbp = dbProps;
    }

    public PhotoAlbumRepository getPhotoAlbumRepository() {
        return newMongoRepo(PhotoAlbumRepository.class);
    }
    
    public UserRepository userRepository() {
        return newMongoRepo(UserRepository.class);
    }
    
    private <T extends Repository<S, ID>, S, ID extends Serializable> T newMongoRepo(Class<T> repoInterface) {

        @SuppressWarnings({ "rawtypes", "unchecked" })
        MongoRepositoryFactoryBean<T, ?, ?> mrfb = new MongoRepositoryFactoryBean();
        mrfb.setRepositoryInterface(repoInterface);
        mrfb.setMongoOperations(mongoOperations(mongoDbFactory(mongo(mongoOptionsFactoryBean()))));
        mrfb.afterPropertiesSet();
        return mrfb.getObject();
    }
    
    public MongoOperations mongoOperations(MongoDbFactory mongoDbFactory) {
        MongoOperations mongoOperations = new MongoTemplate(mongoDbFactory);
        return mongoOperations;
    }

    public MongoDbFactory mongoDbFactory(Mongo mongo) {
        SimpleMongoDbFactory mf = new SimpleMongoDbFactory(mongo, dbp.dbname);
        mf.setWriteConcern(WriteConcern.MAJORITY);
        return mf;
    }

    public Mongo mongo(MongoOptionsFactoryBean mofb) {
        try {
            ServerAddress serverAddress = new ServerAddress(dbp.host, dbp.port);
            
            Mongo mongo = new Mongo(serverAddress, mofb.getObject());
            return mongo;
        } catch (UnknownHostException uhe) {
            throw new RuntimeException(uhe);
        }
    }

    public MongoOptionsFactoryBean mongoOptionsFactoryBean() {
        MongoOptionsFactoryBean mofb = new MongoOptionsFactoryBean();
        mofb.setConnectionsPerHost(dbp.connectionsPerHost);
        mofb.setConnectTimeout(dbp.connectTimeout);
        mofb.setMaxAutoConnectRetryTime(dbp.maxAutoConnectRetryTime);
        mofb.setMaxWaitTime(dbp.maxWaitTime);
        mofb.setSlaveOk(dbp.slaveOk);
        mofb.setSocketKeepAlive(dbp.socketKeepAlive);
        mofb.setThreadsAllowedToBlockForConnectionMultiplier(dbp.threadsAllowedToBlockForConnectionMultiplier);
        mofb.setWriteFsync(dbp.writeFsync);
        mofb.setWriteNumber(dbp.writeNumber);
        mofb.setWriteTimeout(dbp.writeTimeout);
        return mofb;
    }

    public MongoExceptionTranslator mongoExceptionTranslator() {
        return new MongoExceptionTranslator();
    }

    public PersistenceExceptionTranslationPostProcessor exceptionTranslatorBootstrap() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}

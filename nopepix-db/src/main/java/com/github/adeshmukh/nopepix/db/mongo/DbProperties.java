package com.github.adeshmukh.nopepix.db.mongo;

import javax.inject.Named;

import com.mongodb.DBPort;

public class DbProperties {

    @Named("mongodbDatabase")
    String dbname = "nopepix-db";

    @Named("connectionsPerHost")
    int connectionsPerHost = 8;

    @Named("connectTimeout")
    int connectTimeout = 1000;

    @Named("maxAutoConnectRetryTime")
    long maxAutoConnectRetryTime = 1000;

    @Named("maxWaitTime")
    int maxWaitTime = 1500;

    @Named("slaveOk")
    boolean slaveOk = true;

    @Named("socketKeepAlive")
    boolean socketKeepAlive = true;

    @Named("threadsAllowedToBlockForConnectionMultiplier")
    int threadsAllowedToBlockForConnectionMultiplier = 4;

    @Named("writeFsync")
    boolean writeFsync = true;

    @Named("writeNumber")
    int writeNumber = 1;

    @Named("writeTimeout")
    int writeTimeout = 0;

    @Named("host")
    String host;

    @Named("port")
    int port = DBPort.PORT;
}

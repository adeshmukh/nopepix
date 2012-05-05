package com.github.adeshmukh.nopepix.rest;

import com.yammer.dropwizard.config.Configuration;

public class PhotoConfiguration extends Configuration {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

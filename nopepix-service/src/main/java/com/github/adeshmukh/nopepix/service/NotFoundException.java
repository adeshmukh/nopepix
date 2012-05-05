package com.github.adeshmukh.nopepix.service;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Class<?> clazz;
    private String id;
    private String message;
    
    public NotFoundException(Class<?> clazz, String id) {
        this.clazz = clazz;
        this.id = id;
        this.message = String.format("[%s@%s] not found", clazz.getName(), id);

    }
    
    public Class<?> getClazz() {
        return clazz;
    }
    
    public String getId() {
        return id;
    }
    
    public String getMessage() {
        return message;
    }
}

package com.github.adeshmukh.nopepix.model.photo;

public class Login {

    private AuthProvider provider;
    private String id;
    public AuthProvider getAuthProvider() {
        return provider;
    }
    public void setAuthProvider(AuthProvider provider) {
        this.provider = provider;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

}

package com.github.adeshmukh.nopepix.model.photo;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.LocalDate;

public class User {
    
    public enum UserState {
        UNVERIFIED,
        VERIFIED,
        INACTIVE
    }

    @JsonIgnore
    private String id;

    private Login login;
    private String first;
    private String last;
    private String emailId;
    private LocalDate birthDate;
    private UserState state = UserState.UNVERIFIED;
    
    public User() {
        
    }
    
    public User(Login login, String first, String last, String emailId, LocalDate birthDate) {
        this.login = login;
        this.first = first;
        this.last = last;
        this.emailId = emailId;
        this.birthDate = birthDate;
    }
    public String getId() {
        return id;
    }
    public Login getLogin() {
        return login;
    }
    public String getFirst() {
        return first;
    }
    public String getLast() {
        return last;
    }
    public String getEmailId() {
        return emailId;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setLogin(Login login) {
        this.login = login;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public User copy() {
        return new User(login, first, last, emailId, birthDate);
    }
    public User deactivate() {
        if (state == UserState.INACTIVE) {
            throw new IllegalStateException();
        }
        state = UserState.INACTIVE;
        return this;
    }
    public User activate() {
        if (state != UserState.UNVERIFIED) {
            throw new IllegalStateException();
        }
        state = UserState.VERIFIED;
        return this;
    }
    
    /**
     * Allow a previously inactive user to try to be active again.
     * This changes internal state from INACTIVE to UNVERIFIED.
     * To completely activate the user, this needs to be followed by {#activate()}.
     * @return
     */
    public User resurrect() {
        if (state != UserState.INACTIVE) {
            throw new IllegalStateException();
        }
        state = UserState.UNVERIFIED;
        return this;
    }
    public boolean isActive() {
        return state == UserState.VERIFIED;
    }
}

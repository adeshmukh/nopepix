package com.github.adeshmukh.nopepix.service;

import java.util.List;

import javax.inject.Inject;

import com.github.adeshmukh.nopepix.db.mongo.UserRepository;
import com.github.adeshmukh.nopepix.model.photo.User;

public class UserService {

    private UserRepository userRepo;

    @Inject
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    
    public User add(User u) {
        // TODO: exception cases
        return userRepo.save(u);
    }
    
    public void update(User u) {
        // TODO: exception cases
        userRepo.save(u);
    }

    public List<User> allUsers() {
        return userRepo.findAll();
    }

    public User getUser(String userId) {
        User user = userRepo.findOne(userId);
        if (user == null) {
            notFound(userId);
        }
        return user;
    }

    public void deactivate(String userId) throws IllegalStateException, NotFoundException {
        User user = userRepo.findOne(userId);
        if (user == null) {
            notFound(userId);
        } else if (user.isActive()) {
            userRepo.save(user.deactivate());
        }
    }

    private static void notFound(String userId) {
        throw new NotFoundException(User.class, userId);
    }
}

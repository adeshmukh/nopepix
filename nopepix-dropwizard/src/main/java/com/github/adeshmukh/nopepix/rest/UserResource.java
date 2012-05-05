package com.github.adeshmukh.nopepix.rest;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.github.adeshmukh.nopepix.model.photo.User;
import com.github.adeshmukh.nopepix.service.UserService;
import com.yammer.metrics.annotation.Timed;

@Path("/user")
public class UserResource {

    private UserService userService;
    
    @Inject
    public UserResource(UserService userService) {
        this.userService = userService;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed
    public Response addUser(@Context UriInfo uriInfo, User user) {
        user = userService.add(user.copy());
        URI userUri = uriInfo.getAbsolutePathBuilder().path(user.getId()).build();
        return Response.created(userUri).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public List<User> getUsers() {
        return userService.allUsers();
    }
    
    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public User getUser(@PathParam("userId") String userId) {
        return userService.getUser(userId);
    }
    
    @POST
    @Path("/{userId}/deactivation")
    @Timed
    public Response deactivateUser(@PathParam("userId") String userId) {
        userService.deactivate(userId);
        return Response.ok().build();
    }
}

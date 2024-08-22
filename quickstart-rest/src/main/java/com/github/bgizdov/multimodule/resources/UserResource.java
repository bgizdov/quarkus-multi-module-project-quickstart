package com.github.bgizdov.multimodule.resources;

import com.github.bgizdov.multimodule.entities.User;
import com.github.bgizdov.multimodule.exeptions.UserNotFoundException;
import com.github.bgizdov.multimodule.services.UserService;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/** A simple REST resource for users. */
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

  @Inject UserService service;

  @GET
  @Path("/{user_id}")
  @Blocking
  public User hello(@PathParam("user_id") Integer userId) throws UserNotFoundException {
    return service.getUser(userId);
  }

  @GET
  @Path("/")
  @Blocking
  public List<User> getAllUsers() {
    return service.getAllUsers();
  }

  @GET
  @Path("/{user_id}/helloConfig")
  @Blocking
  public String helloConfig(@PathParam("user_id") Integer userId) throws UserNotFoundException {
    return service.getGreetingMessage(userId);
  }

  @GET
  @Path("/{user_id}/helloCoreConfig")
  @Blocking
  public String helloCoreConfig(@PathParam("user_id") Integer userId) throws UserNotFoundException {
    return service.getCoreGreetingMessage(userId);
  }
}

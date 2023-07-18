package com.github.bgizdov.multimodule.resources;

import com.github.bgizdov.multimodule.entities.User;
import com.github.bgizdov.multimodule.services.UserService;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

  @Inject
  UserService service;

  @GET
  @Path("/hello")
  @Blocking
  public User hello() {
    return service.getUser();
  }
}
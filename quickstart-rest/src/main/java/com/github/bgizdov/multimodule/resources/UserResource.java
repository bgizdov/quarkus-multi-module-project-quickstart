package com.github.bgizdov.multimodule.resources;

import com.github.bgizdov.multimodule.entities.User;
import com.github.bgizdov.multimodule.services.UserService;
import io.smallrye.common.annotation.Blocking;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
package com.github.bgizdov.multimodule.services;

import com.github.bgizdov.multimodule.entities.User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService {
  public User getUser() {
    var user = new User(1, "foobar", "baz");
    return user;
  }
}

package com.github.bgizdov.multimodule.services;

import com.github.bgizdov.multimodule.entities.User;
import com.github.bgizdov.multimodule.exeptions.UserNotFoundException;
import com.github.bgizdov.multimodule.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/** A simple service for getting user data. */
@ApplicationScoped
public class UserService {
  @Inject UserRepository userRepository;

  // Property is defined in core and rest, it is overridden in rest
  @ConfigProperty(name = "quickstart.common.greeting.message")
  String commonGreetingMessage;

  @ConfigProperty(name = "quickstart.core.greeting.message")
  String coreGreetingMessage;

  public User getUser(int userId) throws UserNotFoundException {
    return userRepository.getUserById(userId);
  }

  public String getGreetingMessage(int userId) throws UserNotFoundException {
    return String.format(commonGreetingMessage, getUser(userId).userName());
  }

  public String getCoreGreetingMessage(int userId) throws UserNotFoundException {
    return String.format(coreGreetingMessage, getUser(userId).userName());
  }

  public List<User> getAllUsers() {
    return userRepository.getUsers();
  }
}

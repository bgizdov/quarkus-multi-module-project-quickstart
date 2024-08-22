package com.github.bgizdov.multimodule.repositories;

import com.github.bgizdov.multimodule.entities.User;
import com.github.bgizdov.multimodule.exeptions.UserNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Map;

/** A simple hardcoded repository for users. */
@ApplicationScoped
public class UserRepository {
  private final Map<Integer, User> users =
      Map.of(
          1, new User(1, "alices", "Alice", "Smith"),
          2, new User(2, "bobb", "Bob", "Brown"),
          3, new User(3, "charliej", "Charlie", "Jones"));

  /**
   * Gets user by id.
   *
   * @param id the id
   * @return the user by id
   */
  public User getUserById(int id) throws UserNotFoundException {
    if (users.containsKey(id)) {
      return users.get(id);
    } else {
      throw new UserNotFoundException("User not found with ID: " + id);
    }
  }

  /**
   * Gets users.
   *
   * @return the users
   */
  public List<User> getUsers() {
    return List.copyOf(users.values());
  }
}

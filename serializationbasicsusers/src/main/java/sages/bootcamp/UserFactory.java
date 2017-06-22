package sages.bootcamp;

public class UserFactory {
  public User createUser(String name,
                         int age,
                         String username,
                         String password) {
    return new User(name, age, new Credentials(username, password));
  }
}

package sages.bootcamp;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
  private final String name;
  private final int age;
  private final Credentials credentials;

  public User(String name, int age, Credentials credentials) {
    this.name = name;
    this.age = age;
    this.credentials = credentials;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Credentials getCredentials() {
    return credentials;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return age == user.age &&
        Objects.equals(name, user.name) &&
        Objects.equals(credentials, user.credentials);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, credentials);
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", credentials=" + credentials +
        '}';
  }
}

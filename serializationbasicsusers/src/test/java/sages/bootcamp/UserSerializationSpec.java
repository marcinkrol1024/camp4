package sages.bootcamp;


import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class UserSerializationSpec {

  private final UserFactory userFactory = new UserFactory();

  @Test
  public void shouldWriteUsersToFileAndReadTheSameUsers() throws IOException, ClassNotFoundException {
    // given
    List<User> expectedUsers = Arrays.asList(
        userFactory.createUser("Marcin", 25, "marcin", "costam"),
        userFactory.createUser("Kamil", 26, "kamillll", "dddd123"),
        userFactory.createUser("Ania", 27, "anka", "haslooo")
    );

    // when
    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("users.bin"))) {
      outputStream.writeObject(expectedUsers);
    }

    List<User> actualUsers;
    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("users.bin"))) {
      actualUsers = (List<User>) inputStream.readObject();
    }

    // then
    Assert.assertEquals(expectedUsers, actualUsers);
  }
}
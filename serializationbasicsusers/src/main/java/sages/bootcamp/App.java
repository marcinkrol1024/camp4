package sages.bootcamp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class App {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    saveUsers();
    loadUsers();
  }

  private static void saveUsers() throws IOException {
    UserFactory userFactory = new UserFactory();

    List<User> users = Arrays.asList(
        userFactory.createUser("Marcin", 25, "marcin", "costam"),
        userFactory.createUser("Kamil", 26, "kamillll", "dddd123"),
        userFactory.createUser("Ania", 27, "anka", "haslooo")
    );

    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("users.bin"))) {
      outputStream.writeObject(users);
    }
  }

  private static void loadUsers() throws IOException, ClassNotFoundException {
    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("users.bin"))) {
      List<User> users = (List<User>) inputStream.readObject();
      System.out.println(users);
    }
  }
}

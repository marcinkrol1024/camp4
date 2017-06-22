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
    // zapisuję obiekty
    saveBuildings();

    // sprawdzam, czy uda się odczytać
    loadBuildings();

    // shop
    saveShop();
    loadShop();
  }

  private static void saveShop() throws IOException {
    Shop shop = new Shop(Arrays.asList(1, 2, 3));
    shop.getSumOfPrices();
    System.out.println(shop);

    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("shop.bin"))) {
      outputStream.writeObject(shop);
    }
  }

  private static void loadShop() throws IOException, ClassNotFoundException {
    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("shop.bin"))) {
      Shop shops = (Shop) inputStream.readObject();
      System.out.println(shops);
    }
  }

  private static void saveBuildings() throws IOException {
    List<Building> buildings = Arrays.asList(
        new Building(10, "ul. Hoża 15"),
        new Building(20, "ul. Chmielna 10")
    );

    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("buildings.bin"))) {
      outputStream.writeObject(buildings);
    }
  }

  private static void loadBuildings() throws IOException, ClassNotFoundException {
    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("buildings.bin"))) {
      List<Building> buildings = (List<Building>) inputStream.readObject();
      System.out.println(buildings);
    }
  }
}

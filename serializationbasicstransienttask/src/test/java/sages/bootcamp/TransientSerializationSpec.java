package sages.bootcamp;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class TransientSerializationSpec {
  @Test
  public void should() throws IOException, ClassNotFoundException {
    // given
    Building savedBuilding = new Building(Arrays.asList(1, 2, 3));

    // when cache is calculated
    savedBuilding.getAllInhabitantsCount();

    // and building is save
    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("building.bin"))) {
      outputStream.writeObject(savedBuilding);
    }

    // and building is loaded
    Building loadedBuilding;
    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("building.bin"))) {
      loadedBuilding = (Building) inputStream.readObject();
    }

    // then
    Assert.assertNotEquals(savedBuilding.getAllInhabitantsCountCache, null);
    Assert.assertEquals(loadedBuilding.getAllInhabitantsCountCache, null);
  }
}
package sages.bootcamp;

import java.io.Serializable;

public class Building implements Serializable {
  private final int inhabitantsCount;
  private final String address;

  public Building(int inhabitantsCount, String address) {
    this.inhabitantsCount = inhabitantsCount;
    this.address = address;
  }

  @Override
  public String toString() {
    return "Building{" +
        "inhabitantsCount=" + inhabitantsCount +
        ", address='" + address + '\'' +
        '}';
  }
}

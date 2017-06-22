package sages.bootcamp;

import java.io.Serializable;
import java.util.List;

public class Building implements Serializable {
  private final List<Integer> apartmentInhabitantsCounts;

  // package-private for testing purposes
  transient Integer getAllInhabitantsCountCache = null;

  public Building(List<Integer> apartmentInhabitantsCounts) {
    this.apartmentInhabitantsCounts = apartmentInhabitantsCounts;
  }

  int getAllInhabitantsCount() {
    if (getAllInhabitantsCountCache == null) {
      int sum = 0;
      for (Integer apartmentInhabitantsCount : apartmentInhabitantsCounts) {
        sum += apartmentInhabitantsCount;
      }
      getAllInhabitantsCountCache = sum;
    }
    return getAllInhabitantsCountCache;
  }
}

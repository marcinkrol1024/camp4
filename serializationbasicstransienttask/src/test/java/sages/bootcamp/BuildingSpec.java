package sages.bootcamp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BuildingSpec {

  @Test
  public void shouldGetSumOfAllInhabitants() {
    // given
    Building building = new Building(Arrays.asList(1, 2, 3));
    int expectedInhabitantsCount = 6;

    // when
    int actualInhabitantsCount = building.getAllInhabitantsCount();

    // then
    Assert.assertEquals(expectedInhabitantsCount, actualInhabitantsCount);
  }

}
package sages.bootcamp;

import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class ShopSpec {
  @Test
  public void shouldGetDiscountedPriceForAProduct() {
    // given
    Map<String, Integer> productToPrice = new HashMap<>();
    productToPrice.put("Kawa", 8);

    Map<String, Integer> dayOfWeekToDiscount = new HashMap<>();
    dayOfWeekToDiscount.put("MONDAY", 1);
    dayOfWeekToDiscount.put("TUESDAY", 2);
    dayOfWeekToDiscount.put("WEDNESDAY", 3);
    dayOfWeekToDiscount.put("THURSDAY", 4);
    dayOfWeekToDiscount.put("FRIDAY", 5);
    dayOfWeekToDiscount.put("SATURDAY", 6);
    dayOfWeekToDiscount.put("SUNDAY", 7);

    Clock currentTimeClock = Clock.fixed(Instant.parse("2017-06-19T08:08:08Z"), ZoneId.of("UTC"));

    Shop shop = new Shop(productToPrice, dayOfWeekToDiscount, currentTimeClock);

    int expectedKawaPriceOnMonday = 7;

    // when
    int actualKawaPriceOnMonday = shop.getDiscountedProductPrice("Kawa");

    // then
    Assert.assertEquals(expectedKawaPriceOnMonday, actualKawaPriceOnMonday);
  }
}
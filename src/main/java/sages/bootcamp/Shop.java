package sages.bootcamp;

import java.util.Map;

public class Shop {
  private final Map<String, Integer> productToPrice;
  private final Map<String, Integer> dayOfWeekToDiscount;

  public Shop(Map<String, Integer> productToPrice, Map<String, Integer> dayOfWeekToDiscount) {
    this.productToPrice = productToPrice;
    this.dayOfWeekToDiscount = dayOfWeekToDiscount;
  }

  // discountedProductPrice = productPrice - currentDiscount
  int getDiscountedProductPrice(String product) {
    throw new UnsupportedOperationException("Not implemented"); // todo implement
  }
}

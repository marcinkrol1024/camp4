package sages.bootcamp;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Map;

// dostaję aktualną cenę produktu obniżoną o zniżkę w zależności od dnia tygodnia
public class Shop {
  private final Map<String, Integer> productToPrice;
  private final Map<String, Integer> dayOfWeekToDiscount;
  private final Clock currentTimeClock;

  public Shop(Map<String, Integer> productToPrice,
              Map<String, Integer> dayOfWeekToDiscount,
              Clock currentTimeClock) {
    this.productToPrice = productToPrice;
    this.dayOfWeekToDiscount = dayOfWeekToDiscount;
    this.currentTimeClock = currentTimeClock;
  }

  // discountedProductPrice = productPrice - currentDiscount
  // LocalDate.now().getDayOfWeek();
  int getDiscountedProductPrice(String product) {
    int productPrice = productToPrice.get(product);
    String dayOfWeek = getDayOfWeek(currentTimeClock);
    int discount = dayOfWeekToDiscount.get(dayOfWeek);
    return productPrice - discount;
  }

  private String getDayOfWeek(Clock clock) {
    return LocalDate.now(clock).getDayOfWeek().name();
  }
}

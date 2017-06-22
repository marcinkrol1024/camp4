package sages.bootcamp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Shop implements Serializable {
  private final List<Integer> prices;
  private transient Integer cachedSum;

  public Shop(List<Integer> prices) {
    this.prices = new ArrayList<>(prices);
  }

  int getSumOfPrices() {
    if (cachedSum == null) {
      int sum = 0;
      for (Integer price : prices) {
        sum += price;
      }
      cachedSum = sum;
    }
    return cachedSum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Shop shop = (Shop) o;
    return Objects.equals(prices, shop.prices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prices);
  }

  @Override
  public String toString() {
    return "Shop{" +
        "prices=" + prices +
        ", cachedSum=" + cachedSum +
        '}';
  }
}

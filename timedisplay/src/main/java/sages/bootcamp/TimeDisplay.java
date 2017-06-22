package sages.bootcamp;

import java.time.Clock;
import java.time.LocalDate;

public class TimeDisplay {

  private final Clock currentTimeClock;

  public TimeDisplay(Clock currentTimeClock) {
    this.currentTimeClock = currentTimeClock;
  }

  String getDayOfWeek() {
    return LocalDate
        .now(currentTimeClock)
        .getDayOfWeek()
        .name();
  }

  String getMonth() {
    return LocalDate
        .now(currentTimeClock)
        .getMonth()
        .name();
  }
}

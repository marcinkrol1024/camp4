package sages.bootcamp;

import org.junit.Assert;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class TimeDisplaySpec {
  @Test
  public void shouldGetDayOfWeek() {
    // given
    String expectedDayOfWeek = "MONDAY";
    Clock currentTimeClock = getClockForTime("2017-06-19T08:08:08Z");
    TimeDisplay timeDisplay = new TimeDisplay(currentTimeClock);

    // when
    String actualDayOfWeek = timeDisplay.getDayOfWeek();

    // then
    Assert.assertEquals(expectedDayOfWeek, actualDayOfWeek);
  }

  @Test
  public void shouldGetMonth() {
    // given
    String expectedMonth = "JUNE";
    Clock currentTimeClock = getClockForTime("2017-06-19T08:08:08Z");
    TimeDisplay timeDisplay = new TimeDisplay(currentTimeClock);

    // when
    String actualMonth = timeDisplay.getMonth();

    // then
    Assert.assertEquals(expectedMonth, actualMonth);
  }

  private Clock getClockForTime(String time) {
    return Clock.fixed(Instant.parse(time), ZoneId.of("UTC"));
  }
}
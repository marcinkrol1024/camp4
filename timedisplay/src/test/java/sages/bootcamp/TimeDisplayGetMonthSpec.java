package sages.bootcamp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TimeDisplayGetMonthSpec {

  @Parameter(0)
  public String currentTime;
  @Parameter(1)
  public String expectedMonth;


  @Parameters
  public static Collection<Object[]> data() {
    Object[][] data = new Object[][]{
        {"2017-06-19T08:08:08Z", "JUNE"},
        {"2017-01-19T08:08:08Z", "JANUARY"}
    };
    return Arrays.asList(data);
  }

  @Test
  public void shouldGetMonth() {
    // given
    Clock currentTimeClock = getClockForTime(currentTime);
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
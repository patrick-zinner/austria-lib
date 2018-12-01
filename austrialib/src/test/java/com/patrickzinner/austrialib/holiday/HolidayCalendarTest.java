package com.patrickzinner.austrialib.holiday;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;


public class HolidayCalendarTest {

    @Test
    public void testCalculateEaster() {
        HolidayCalendar calendar = new HolidayCalendar();
        Assertions.assertThat(calendar.calculateEasterSunday(2016)).as("easter 2016").isEqualTo(LocalDate.of(2016, 3, 27));
        Assertions.assertThat(calendar.calculateEasterSunday(2017)).as("easter 2017").isEqualTo(LocalDate.of(2017, 4, 16));
        Assertions.assertThat(calendar.calculateEasterSunday(2018)).as("easter 2018").isEqualTo(LocalDate.of(2018, 4, 1));
        Assertions.assertThat(calendar.calculateEasterSunday(2019)).as("easter 2019").isEqualTo(LocalDate.of(2019, 4, 21));
        Assertions.assertThat(calendar.calculateEasterSunday(2020)).as("easter 2020").isEqualTo(LocalDate.of(2020, 4, 12));
    }

}

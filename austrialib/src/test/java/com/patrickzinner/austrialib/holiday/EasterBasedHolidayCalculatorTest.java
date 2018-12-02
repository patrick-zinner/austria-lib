package com.patrickzinner.austrialib.holiday;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


public class EasterBasedHolidayCalculatorTest {

    private EasterBasedHolidayCalculator calendar;

    @Before
    public void setUp() {
        calendar = new EasterBasedHolidayCalculator();
    }

    @Test
    public void testCalculateEaster() {
        assertThat(calendar.calculateEasterSunday(2016)).as("easter 2016").isEqualTo(LocalDate.of(2016, 3, 27));
        assertThat(calendar.calculateEasterSunday(2017)).as("easter 2017").isEqualTo(LocalDate.of(2017, 4, 16));
        assertThat(calendar.calculateEasterSunday(2018)).as("easter 2018").isEqualTo(LocalDate.of(2018, 4, 1));
        assertThat(calendar.calculateEasterSunday(2019)).as("easter 2019").isEqualTo(LocalDate.of(2019, 4, 21));
        assertThat(calendar.calculateEasterSunday(2020)).as("easter 2020").isEqualTo(LocalDate.of(2020, 4, 12));
    }

    @Test
    public void testCalculateGoodFriday() {
        assertThat(calendar.calculateGoodFriday(LocalDate.of(2016, 3, 27))).isEqualTo(LocalDate.of(2016, 3, 25));
        assertThat(calendar.calculateGoodFriday(LocalDate.of(2018, 4, 1))).isEqualTo(LocalDate.of(2018, 3, 30));
        assertThat(calendar.calculateGoodFriday(2016)).isEqualTo(LocalDate.of(2016, 3, 25));
        assertThat(calendar.calculateGoodFriday(2018)).isEqualTo(LocalDate.of(2018, 3, 30));
    }

    @Test
    public void testCalculatePentecostMonday() {
        assertThat(calendar.calculatePentecostMonday(LocalDate.of(2016, 3, 27))).isEqualTo(LocalDate.of(2016, 5, 16));
        assertThat(calendar.calculatePentecostMonday(LocalDate.of(2018, 4, 1))).isEqualTo(LocalDate.of(2018, 5, 21));
        assertThat(calendar.calculatePentecostMonday(2016)).isEqualTo(LocalDate.of(2016, 5, 16));
        assertThat(calendar.calculatePentecostMonday(2018)).isEqualTo(LocalDate.of(2018, 5, 21));
    }

    @Test
    public void testCorpusChristiMonday() {
        assertThat(calendar.calculateCorpusChristi(LocalDate.of(2016, 3, 27))).isEqualTo(LocalDate.of(2016, 5, 26));
        assertThat(calendar.calculateCorpusChristi(LocalDate.of(2018, 4, 1))).isEqualTo(LocalDate.of(2018, 5, 31));
        assertThat(calendar.calculateCorpusChristi(2016)).isEqualTo(LocalDate.of(2016, 5, 26));
        assertThat(calendar.calculateCorpusChristi(2018)).isEqualTo(LocalDate.of(2018, 5, 31));
    }

    @Test
    public void testCalculateAscensionDay() {
        assertThat(calendar.calculateAscensionDay(LocalDate.of(2016, 3, 27))).isEqualTo(LocalDate.of(2016, 5, 5));
        assertThat(calendar.calculateAscensionDay(LocalDate.of(2018, 4, 1))).isEqualTo(LocalDate.of(2018, 5, 10));
        assertThat(calendar.calculateAscensionDay(2016)).isEqualTo(LocalDate.of(2016, 5, 5));
        assertThat(calendar.calculateAscensionDay(2018)).isEqualTo(LocalDate.of(2018, 5, 10));
    }

}

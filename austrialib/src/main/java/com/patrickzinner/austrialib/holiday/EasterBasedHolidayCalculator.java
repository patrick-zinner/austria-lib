package com.patrickzinner.austrialib.holiday;

import java.time.LocalDate;

/**
 * Class for calculation of easter based holidays. Since Easter Sunday is on a different day every year, the holidays need to be calculated for each year respectively.
 */
public class EasterBasedHolidayCalculator {

    /**
     * Calculate Easter Sunday by using Gauss's Easter algorithm
     *
     * @param year year to calculate Easter Sunday for
     * @return Easter Sunday in the given year
     */
    public LocalDate calculateEasterSunday(int year) {
        int easterDay;
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int k = year / 100;
        int p = (8 * k + 13) / 25;
        int q = k / 4;
        int m = (15 + k - p - q) % 30;
        int n = (4 + k - q) % 7;
        int d = (19 * a + m) % 30;
        int e = (2 * b + 4 * c + 6 * d + n) % 7;
        if (d + e == 35) {
            easterDay = 50;
        } else if (d == 28 && e == 6 && (11 * m + 11) % 30 < 19) {
            easterDay = 49;
        } else {
            easterDay = 22 + d + e;
        }
        int month = 3;
        if (easterDay > 31) {
            month++;
            easterDay -= 31;
        }
        return LocalDate.of(year, month, easterDay);
    }

    /**
     * Calculate Easter Monday of a given year. See {@link #calculateEasterSunday(int)}
     *
     * @param year year to calculate Easter Monday for
     * @return Easter Monday in the given year
     */
    public LocalDate calculateEasterMonday(int year) {
        return calculateEasterMonday(calculateEasterSunday(year));
    }

    /**
     * Calculate Easter Monday of a given year. See {@link #calculateEasterSunday(int)}
     *
     * @param easterSunday Easter Sunday that the calculation should be based on
     * @return Easter Monday
     */
    public LocalDate calculateEasterMonday(LocalDate easterSunday) {
        return easterSunday.plusDays(1);
    }

    /**
     * Calculate Ascension Day (Christi Himmelfahrt) of a given year. See {@link #calculateEasterSunday(int)}
     *
     * @param year year to calculate Ascension Day for
     * @return Ascension Day
     */
    public LocalDate calculateAscensionDay(int year) {
        return calculateAscensionDay(calculateEasterSunday(year));
    }


    /**
     * Calculate Ascension Day (Christi Himmelfahrt) of a given year. See {@link #calculateEasterSunday(int)}
     *
     * @param easterSunday Easter Sunday that the calculation should be based on
     * @return Ascension Day
     */
    public LocalDate calculateAscensionDay(LocalDate easterSunday) {
        return easterSunday.plusDays(39);
    }

    /**
     * Calculate Pentecost (Pfingsten) of a given year. See {@link #calculateEasterSunday(int)}
     *
     * @param year year to calculate Pentecost for
     * @return Pentecost (Pfingsten) Day
     */
    public LocalDate calculatePentecost(int year) {
        return calculatePentecost(calculateEasterSunday(year));
    }


    /**
     * Calculate Pentecost (Pfingsten) of a given year. See {@link #calculateEasterSunday(int)}
     *
     * @param easterSunday Easter Sunday that the calculation should be based on
     * @return Pentecost (Pfingsten) Day
     */
    public LocalDate calculatePentecost(LocalDate easterSunday) {
        return easterSunday.plusDays(50);
    }

    /**
     * Calculate Corpus Christi (Fronleichnam) of a given year. See {@link #calculateEasterSunday(int)}
     *
     * @param year year to calculate Corpus Christi for
     * @return Corpus Christi (Fronleichnam) Day
     */
    public LocalDate calculateCorpusChristi(int year) {
        return calculateCorpusChristi(calculateEasterSunday(year));
    }


    /**
     * Calculate Corpus Christi (Fronleichnam) of a given year. See {@link #calculateEasterSunday(int)}
     *
     * @param easterSunday Easter Sunday that the calculation should be based on
     * @return Corpus Christi (Fronleichnam) Day
     */
    public LocalDate calculateCorpusChristi(LocalDate easterSunday) {
        return easterSunday.plusDays(60);
    }

    /**
     * Calculate Good Friday (Karfreitag) of a given year. See {@link #calculateEasterSunday(int)}
     *
     * @param year year to calculate Good Friday (Karfreitag) for
     * @return Good Friday (Karfreitag)
     */
    public LocalDate calculateGoodFriday(int year) {
        return calculateGoodFriday(calculateEasterSunday(year));
    }


    /**
     * Calculate Good Friday (Karfreitag) of a given year. See {@link #calculateEasterSunday(int)}
     *
     * @param easterSunday Easter Sunday that the calculation should be based on
     * @return Good Friday (Karfreitag)
     */
    public LocalDate calculateGoodFriday(LocalDate easterSunday) {
        return easterSunday.minusDays(2);
    }


}

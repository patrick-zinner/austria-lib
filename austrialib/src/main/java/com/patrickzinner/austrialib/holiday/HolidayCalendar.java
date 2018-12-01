package com.patrickzinner.austrialib.holiday;

import java.time.LocalDate;

/**
 * Class for calculation of holidays in Austria
 */
public class HolidayCalendar {

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

}

package com.patrickzinner.austrialib.holiday;

public class HolidayCalendar {

    private EasterBasedHolidayCalculator easterBasedHolidayCalculator;

    public HolidayCalendar() {
        this.easterBasedHolidayCalculator = new EasterBasedHolidayCalculator();
    }

}

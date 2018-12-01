package com.patrickzinner.austrialib.holiday;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

/**
 * Class for calculating public holidays of Austria
 */
public class HolidayCalendar {

    private static final String FIXED_HOLIDAY_FILE = "holiday/fixed-holidays.json";

    private EasterBasedHolidayCalculator easterBasedHolidayCalculator;

    final private Set<FixedHoliday> fixedHolidays;

    public HolidayCalendar() throws IOException {
        this.easterBasedHolidayCalculator = new EasterBasedHolidayCalculator();
        ClassLoader classLoader = getClass().getClassLoader();
        File fixedHolidayfile = new File(Objects.requireNonNull(classLoader.getResource(FIXED_HOLIDAY_FILE)).getFile());
        ObjectMapper mapper = new ObjectMapper();
        FixedHolidayWrapper fixedHolidayWrapper = mapper.readValue(fixedHolidayfile, FixedHolidayWrapper.class);
        fixedHolidays = new HashSet<>(fixedHolidayWrapper.getHolidays());

    }

    public Set<FixedHoliday> getFixedHolidays() {
        return fixedHolidays;
    }

    public List<Holiday> getAllHolidays(int year) {
        List<Holiday> holidays = new ArrayList<>();
        fixedHolidays.stream().map(fixedHoliday -> convert(fixedHoliday, year)).forEach(holidays::add);

        LocalDate easterSunday = easterBasedHolidayCalculator.calculateEasterSunday(year);

        return holidays;
    }


    private Holiday convert(FixedHoliday fixedHoliday, int year) {
        Holiday holiday = new Holiday();
        holiday.setDate(LocalDate.of(year, fixedHoliday.getMonth(), fixedHoliday.getDay()));
        holiday.setDeName(fixedHoliday.getDeName());
        holiday.setEnName(fixedHoliday.getEnName());
        holiday.setLegalHoliday(fixedHoliday.getLegalHoliday());
        holiday.setStates(new HashSet<>(fixedHoliday.getStates()));
        return holiday;
    }


}

package com.patrickzinner.austrialib.holiday;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patrickzinner.austrialib.enums.State;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
        holidays.addAll(calculateEasterBasedHolidays(easterSunday));
        return holidays;
    }

    private List<Holiday> calculateEasterBasedHolidays(LocalDate easterSunday) {
        List<Holiday> result = new ArrayList<>();
        LocalDate easterMonday = easterBasedHolidayCalculator.calculateEasterMonday(easterSunday);
        LocalDate ascensionDay = easterBasedHolidayCalculator.calculateAscensionDay(easterSunday);
        LocalDate pentecostDay = easterBasedHolidayCalculator.calculatePentecostMonday(easterSunday);
        LocalDate corpusChristi = easterBasedHolidayCalculator.calculateCorpusChristi(easterSunday);
        LocalDate goodFriday = easterBasedHolidayCalculator.calculateGoodFriday(easterSunday);
        result.add(createHoliday(easterSunday, "Easter Sunday", "Ostersonntag", true));
        result.add(createHoliday(easterMonday, "Easter Monday", "Ostermontag", true));
        result.add(createHoliday(ascensionDay, "Ascension of Jesus", "Christi Himmelfahrt", true));
        result.add(createHoliday(pentecostDay, "Pentecost", "Pfingstmontag", true));
        result.add(createHoliday(corpusChristi, "Corpus Christi", "Fronleichnam", true));
        result.add(createHoliday(goodFriday, "Good Friday", "Karfreitag", false));
        return result;
    }

    private Holiday createHoliday(LocalDate date, String enName, String deName, boolean legalHoliday) {
        Holiday holiday = new Holiday();
        holiday.setStates(Arrays.stream(State.values()).collect(Collectors.toSet()));
        holiday.setLegalHoliday(legalHoliday);
        holiday.setDate(date);
        holiday.setEnName(enName);
        holiday.setDeName(deName);
        return holiday;
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

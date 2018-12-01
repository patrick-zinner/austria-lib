package com.patrickzinner.austrialib.holiday;

import lombok.Data;

import java.util.Set;

@Data
public class FixedHolidayWrapper {

    private Set<FixedHoliday> holidays;
}

package com.patrickzinner.austrialib.holiday;

import com.patrickzinner.austrialib.enums.State;
import lombok.Data;

import java.util.Set;

@Data
public class FixedHoliday {
    private Integer month;
    private Integer day;
    private String deName;
    private String enName;
    private Boolean legalHoliday;
    private Set<State> states;
}

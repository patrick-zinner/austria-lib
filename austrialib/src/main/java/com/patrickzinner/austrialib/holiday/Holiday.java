package com.patrickzinner.austrialib.holiday;

import com.patrickzinner.austrialib.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Holiday {
    private LocalDate date;
    private String deName;
    private String enName;
    private Boolean legalHoliday;
    private Set<State> states;
}

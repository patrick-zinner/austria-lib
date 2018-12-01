package com.patrickzinner.austrialib.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 9 States of Austria
 */
@Getter
@AllArgsConstructor
public enum State {

    BURGENLAND("Burgenland"),
    CARINTHIA("Kärnten"),
    LOWER_AUSTRIA("Niederösterrreich"),
    SALZBURG("Salzburg"),
    STYRIA("Steiermark"),
    TYROL("Tirol"),
    UPPER_AUSTRIA("Oberösterreich"),
    VIENNA("Wien"),
    VORARLBERG("Vorarlberg");
    /**
     * State's german language name
     */
    private String germanName;


}

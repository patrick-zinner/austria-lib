package com.patrickzinner.austrialib.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

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

    private String germanName;


}

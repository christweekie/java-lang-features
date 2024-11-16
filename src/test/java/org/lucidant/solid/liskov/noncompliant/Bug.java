package org.lucidant.solid.liskov.noncompliant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;


@AllArgsConstructor
@Generated
public class Bug extends Task {
    private int severityLevel;

    public void initialiseSeverity() {
        ///
    }
}

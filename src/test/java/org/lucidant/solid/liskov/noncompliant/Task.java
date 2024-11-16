package org.lucidant.solid.liskov.noncompliant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {
    private String title;
    private String description;
    private String status;
    private boolean inProgress;

}

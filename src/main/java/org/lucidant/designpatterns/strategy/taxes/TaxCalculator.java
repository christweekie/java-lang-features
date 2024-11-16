package org.lucidant.designpatterns.strategy.taxes;


import org.lucidant.designpatterns.strategy.personnel.Employee;

public interface TaxCalculator {
    double calculate(Employee employee);
}

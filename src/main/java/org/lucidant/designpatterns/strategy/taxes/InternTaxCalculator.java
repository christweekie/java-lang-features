package org.lucidant.designpatterns.strategy.taxes;

import org.lucidant.designpatterns.strategy.personnel.Employee;

public class InternTaxCalculator implements TaxCalculator {
    private static final int INCOME_TAX_PERCENTAGE = 16;

    public double calculate(Employee employee) {
        int monthlyIncome = employee.getMonthlyIncome();
        if (monthlyIncome < 350) {
            return 0;
        } else {
            return (double) (monthlyIncome * INCOME_TAX_PERCENTAGE) / 100;
        }
    }
}

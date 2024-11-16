package org.lucidant.designpatterns.strategy.taxes;


import org.lucidant.designpatterns.strategy.personnel.Employee;

public class FullTimeTaxCalculator implements TaxCalculator {
    private static final int RETIREMENT_TAX_PERCENTAGE = 10;
    private static final int INCOME_TAX_PERCENTAGE = 16;
    private static final int BASE_HEALTH_INSURANCE = 100;


    public double calculate(Employee employee) {
        return BASE_HEALTH_INSURANCE +
                (double) (employee.getMonthlyIncome() * RETIREMENT_TAX_PERCENTAGE) / 100 +
                (double) (employee.getMonthlyIncome() * INCOME_TAX_PERCENTAGE) / 100;

    }
}

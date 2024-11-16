package org.lucidant.designpatterns.strategy.taxes;


import org.lucidant.designpatterns.strategy.personnel.Employee;

public class PartTimeTaxCalculator implements TaxCalculator {
    private static final int RETIREMENT_TAX_PERCENTAGE = 5;
    private static final int INCOME_TAX_PERCENTAGE = 16;
    private static final int BASE_HEALTH_INSURANCE = 100;

    public double calculate(Employee employee) {
        int monthlyIncome = employee.getMonthlyIncome();
        return BASE_HEALTH_INSURANCE +
                (double) (monthlyIncome * RETIREMENT_TAX_PERCENTAGE) / 100 +
                (double) (monthlyIncome * INCOME_TAX_PERCENTAGE) / 100;
    }
}

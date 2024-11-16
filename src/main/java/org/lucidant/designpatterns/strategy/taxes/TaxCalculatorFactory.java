
package org.lucidant.designpatterns.strategy.taxes;

import org.lucidant.designpatterns.strategy.personnel.Employee;
import org.lucidant.designpatterns.strategy.personnel.FullTimeEmployee;
import org.lucidant.designpatterns.strategy.personnel.Intern;
import org.lucidant.designpatterns.strategy.personnel.PartTimeEmployee;

public class TaxCalculatorFactory {
    public static TaxCalculator create(Employee employee) {
        if (employee instanceof FullTimeEmployee) {
            return new FullTimeTaxCalculator();
        }

        if (employee instanceof PartTimeEmployee) {
            return new PartTimeTaxCalculator();
        }

        if (employee instanceof Intern) {
            return new InternTaxCalculator();
        }

        throw new RuntimeException("Invalid employee type");
    }
}

package org.lucidant.designpatterns.strategy.taxes;

import org.junit.jupiter.api.Test;
import org.lucidant.designpatterns.strategy.personnel.Employee;
import org.lucidant.designpatterns.strategy.personnel.FullTimeEmployee;
import org.lucidant.designpatterns.strategy.personnel.Intern;
import org.lucidant.designpatterns.strategy.personnel.PartTimeEmployee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TaxCalculatorFactoryTest {

    @Test
    void createFullTimeEmployeeTaxCalculator() {
        Employee employee = new FullTimeEmployee("John Doe", 50000);
        TaxCalculator calculator = TaxCalculatorFactory.create(employee);
        assertThat(calculator).isInstanceOf(FullTimeTaxCalculator.class);
    }

    @Test
    void createPartTimeEmployeeTaxCalculator() {
        Employee employee = new PartTimeEmployee("Jane Smith", 20000);
        TaxCalculator calculator = TaxCalculatorFactory.create(employee);
        assertThat(calculator).isInstanceOf(PartTimeTaxCalculator.class);
    }

    @Test
    void createInternTaxCalculator() {
        Employee employee = new Intern("Alex Johnson", 10000, 2);
        TaxCalculator calculator = TaxCalculatorFactory.create(employee);
        assertThat(calculator).isInstanceOf(InternTaxCalculator.class);
    }

    @Test
    void createWithInvalidEmployeeType() {
        Employee employee = new Employee("Invalid Employee", 0) {
            // Creating a mock subclass of Employee to simulate an invalid employee type
        };
        assertThatThrownBy(() -> TaxCalculatorFactory.create(employee))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Invalid employee type");
    }
}

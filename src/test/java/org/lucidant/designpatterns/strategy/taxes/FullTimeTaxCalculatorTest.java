package org.lucidant.designpatterns.strategy.taxes;

import org.junit.jupiter.api.Test;
import org.lucidant.designpatterns.strategy.personnel.Employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class FullTimeTaxCalculatorTest {

    private final FullTimeTaxCalculator calculator = new FullTimeTaxCalculator();

    @Test
    void testCalculate_LowIncomeEmployee() {
        Employee employee = mock(Employee.class);
        when(employee.getMonthlyIncome()).thenReturn(1500);

        double result = calculator.calculate(employee);

        assertThat(result).isEqualTo(490.0);
    }

    @Test
    void testCalculate_HighIncomeEmployee() {
        Employee employee = mock(Employee.class);
        when(employee.getMonthlyIncome()).thenReturn(8000);

        double result = calculator.calculate(employee);

        assertThat(result).isEqualTo(2180.0);
    }

    @Test
    void testCalculate_ZeroIncomeEmployee() {
        Employee employee = mock(Employee.class);
        when(employee.getMonthlyIncome()).thenReturn(0);

        double result = calculator.calculate(employee);

        assertThat(result).isEqualTo(100.0);
    }

    @Test
    void testCalculate_NegativeIncomeEmployee() {
        Employee employee = mock(Employee.class);
        when(employee.getMonthlyIncome()).thenReturn(-3000);

        double result = calculator.calculate(employee);

        assertThat(result).isEqualTo(-680.0);
    }
}

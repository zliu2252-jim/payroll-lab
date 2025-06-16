package org.example;

/**
 * PayCalculator provides methods to compute payroll-related values,
 */
public class PayCalculator {

    /**
     * Calculates gross pay at a fixed hourly rate of $16.78.
     *
     * @param hoursWorked the total number of hours worked
     * @return the gross pay
     */
    public double grossPay(double hoursWorked) {
        return hoursWorked * 16.78;
    }
}
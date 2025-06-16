package org.example;

import java.util.Scanner;

/**
 * The payrollApp collects employee hours and dependents,
 * calculates gross pay, deductions, net pay,hours worked, and pay rate
 * and displays a formatted payroll summary.
 */
public class payrollApp {
    public static void main(String[] args) {
        final double PAY_RATE = 16.78;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Payroll Calculator!");

        System.out.print  ("Enter the Number of Dependents: ");
        int numberOfDependents = scanner.nextInt();

        System.out.print  ("Enter the Number of Hours You Worked: ");
        double hoursWorked = scanner.nextDouble();

        scanner.close();

        // Instantiate PayCalculator to compute gross pay
        PayCalculator payCalculator = new PayCalculator();
        double grossPay   = payCalculator.grossPay(hoursWorked);
        double deductions = numberOfDependents * 3.0;
        double netPay     = grossPay - deductions;

        // Print the input
        System.out.println("\nHours worked: " + hoursWorked);
        System.out.println("Pay rate: " + PAY_RATE);

        // Print payroll results
        System.out.println("\nYour gross pay is: " + grossPay);
        System.out.println("Your deductions are: " + deductions);
        System.out.println("Your net pay is: " + netPay);

        System.out.println("\nThank you for using the Payroll Calculator!");
    }
}
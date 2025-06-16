package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for payrollApp, verifying console prompts and
 * correct payroll calculations.
 */
class TestPayroll {

    // Preserve original System.in and System.out streams for restoration
    InputStream originalIn = System.in;
    PrintStream originalOut = System.out;
    // Captures output printed to System.out
    ByteArrayOutputStream outContent;

    /**
     * Redirects System.out to a ByteArrayOutputStream before each test.
     */
    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Restores System.in and System.out to their original streams after each test.
     */
    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    /**
     * Tests payrollApp with sample input, verifying prompts and calculated values.
     */
    @Test
    void itRunsPayrollWithSampleInput() {
        // Define test parameters
        int dependents = 4;
        double hoursWorked = 30.0;
        // Build simulated input string
        String simulatedInput = dependents + "\n" + hoursWorked + "\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Run the application entry point
        payrollApp.main(new String[]{});

        // Output
        String output = outContent.toString();

        // Verify prompts are displayed
        assertTrue(output.contains("Welcome to the Payroll Calculator!"));
        assertTrue(output.contains("Enter the Number of Dependents:"));
        assertTrue(output.contains("Enter the Number of Hours You Worked:"));

        // Verify input is correctly
        assertTrue(output.contains("Hours worked: " + hoursWorked));
        assertTrue(output.contains("Pay rate: 16.78"));

        // Calculate the results
        double expectedGross = hoursWorked * 16.78;
        double expectedDeductions = dependents * 3.0;
        double expectedNet = expectedGross - expectedDeductions;

        // Verify payroll calculations
        assertTrue(output.contains("Your gross pay is: " + expectedGross));
        assertTrue(output.contains("Your deductions are: " + expectedDeductions));
        assertTrue(output.contains("Your net pay is: " + expectedNet));

        assertTrue(output.contains("Thank you for using the Payroll Calculator!"));
    }

    /**
     * Tests payrollApp with an overtime scenario, verifying pay calculations.
     */
    @Test
    void itCalculatesGrossPayWithOvertime() {
        // Define test parameters
        int dependents = 2;
        double hoursWorked = 45.0;
        // Build input string dynamically
        String simulatedInput = dependents + "\n" + hoursWorked + "\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        payrollApp.main(new String[]{});

        // Output
        String output = outContent.toString();

        // Calculate expected values
        double expectedGross = hoursWorked * 16.78;
        double expectedDeductions = dependents * 3.0;
        double expectedNet = expectedGross - expectedDeductions;

        // Verify inputs
        assertTrue(output.contains("Hours worked: " + hoursWorked));
        assertTrue(output.contains("Pay rate: 16.78"));

        // Verify output
        assertTrue(output.contains("Your gross pay is: " + expectedGross));
        assertTrue(output.contains("Your deductions are: " + expectedDeductions));
        assertTrue(output.contains("Your net pay is: " + expectedNet));
    }
}

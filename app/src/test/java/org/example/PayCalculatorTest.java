package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the PayCalculator class, verifying gross pay calculations.
 */
public class PayCalculatorTest {

    // PayCalculator instance used in each test
    PayCalculator payCalculator;

    /**
     * Initialize a fresh PayCalculator.
     */
    @BeforeEach
    void setUp() {
        payCalculator = new PayCalculator();
    }

    /**
     * When zero hours are worked, gross pay should be zero.
     */
    @Test
    void itCalculatesThePayForZeroHoursWorked() {
        // Verify gross pay for 0 hours
        assertEquals(
                0.0,
                payCalculator.grossPay(0),
                "grossPay(0) should return 0"
        );
    }

    /**
     * When one hour is worked, gross pay need to equal the hourly rate ($16.78).
     */
    @Test
    void itCalculatesThePayForOneHourWorked() {
        // Verify gross pay for 1 hour
        assertEquals(
                16.78,
                payCalculator.grossPay(1),
                "grossPay(1) should return the hourly rate of 16.78"
        );
    }
}

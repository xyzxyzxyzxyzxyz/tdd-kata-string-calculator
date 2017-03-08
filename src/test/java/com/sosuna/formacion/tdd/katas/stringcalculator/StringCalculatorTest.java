package com.sosuna.formacion.tdd.katas.stringcalculator;


import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StringCalculatorTest {

    /**
     * Feature #1: Empty string should return 0
     *
     * Test #1.1: Empty string should return 0
     */
    @Test
    public void emptyStringShouldReturn0() {
        assertResultEquals("Empty string should return 0",
                "", 0);
    }


    /**
     * Feature #2: Single number should return that same number
     *
     * Test #2.1: Single number should return that same number
     */
    @Test
    public void singleNumberShouldReturnSameNumber() {
        assertResultEquals("Single number should return that same number",
                "1", 1);
    }


    /**
     * Feature #3: Two numbers should return their sum
     *
     * Test #1: Two numbers should return their sum
     */
    @Test
    public void twoNumbersShouldReturnSum() {
        assertResultEquals("Two numbers should return the sum of both",
                "1,2", 3);
    }
    

    private void assertResultEquals(String message, String test, int expectedResult) {
        int result = StringCalculator.calculate(test);
        assertEquals(message, expectedResult, result);
    }

}

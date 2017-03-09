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


    /**
     * Feature #4: The calculate() method should be able to handle an unknown number of numbers
     *
     * Test #1: The calculate() method should be able to handle 3 numbers
     */
    @Test
    public void calculateShouldAllow3Numbers() {
        assertResultEquals("The calculate() method should be able to handle 3 numbers",
                "1,2,3", 6);
    }


    /**
     * Feature #4: The calculate() method should be able to handle an unknown number of numbers
     *
     * Test #4.1: The calculate() method should be able to handle 30 numbers
     */
    @Test
    public void calculateShouldAllow30Numbers() {
        assertResultEquals("The calculate() method should be able to handle 3 numbers",
                "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30",
                465);   // (1+30)*15
    }


    private void assertResultEquals(String message, String test, int expectedResult) {
        int result = StringCalculator.calculate(test);
        assertEquals(message, expectedResult, result);
    }

}

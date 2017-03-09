package com.sosuna.formacion.tdd.katas.stringcalculator;


import org.junit.Test;

public class StringCalculatorTest {

    /**
     * Feature #1: Empty string should return 0
     *
     * Test #1.1: Empty string should return 0
     */
    @Test
    public void emptyStringShouldReturn0() {
        StringCalculatorTestUtils.assertResultEquals("Empty string should return 0",
                "", 0);
    }


    /**
     * Feature #2: Single number should return that same number
     *
     * Test #2.1: Single number should return that same number
     */
    @Test
    public void singleNumberShouldReturnSameNumber() {
        StringCalculatorTestUtils.assertResultEquals("Single number should return that same number",
                "1", 1);
    }


    /**
     * Feature #3: Two numbers should return their sum
     *
     * Test #3.1: Two numbers should return their sum
     */
    @Test
    public void twoNumbersShouldReturnSum() {
        StringCalculatorTestUtils.assertResultEquals("Two numbers should return the sum of both",
                "1,2", 3);
    }


}

package com.sosuna.formacion.tdd.katas.stringcalculator;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

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


    /**
     * Feature #7: Negative numbers should throw an exception
     *
     * Test #7.1: One negative number should throw an exception
     */
    @Test(expected = StringCalculator.NegativeNumbersException.class)
    public void oneNegativeNumberShouldThrowAnException() {
        StringCalculator.calculate("-1,2");
    }


    /**
     * Feature #8: Numbers bigger than 1000 should be ignored
     *
     * Test #8.1: Three numbers bigger than 1000 are ignored
     */
    @Test
    public void threeNumbers1000PlusAreIgnored() {
        StringCalculatorTestUtils.assertResultEquals(
                "The three numbers bigger than 1000 should have been ignored",
                "1,1001,2,2002,3,3003",
                6);
    }

}

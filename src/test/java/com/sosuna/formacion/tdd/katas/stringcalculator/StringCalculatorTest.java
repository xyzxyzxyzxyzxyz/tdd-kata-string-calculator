package com.sosuna.formacion.tdd.katas.stringcalculator;


import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StringCalculatorTest {

    @Test
    public void emptyStringShouldReturn0() {
        assertResultEquals("Empty string should return 0",
                "", 0);
    }


    @Test
    public void singleNumberShouldReturnSameNumber() {
        assertResultEquals("Single number should return that same number",
                "1", 1);
    }


    //@Test
    public void testTemplate() {
        assertResultEquals("MESSAGE",
                "TEST", 9999999);
    }


    private void assertResultEquals(String message, String test, int expectedResult) {
        int result = StringCalculator.calculate(test);
        assertEquals(message, expectedResult, result);
    }

}

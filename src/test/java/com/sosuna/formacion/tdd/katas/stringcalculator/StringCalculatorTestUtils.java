package com.sosuna.formacion.tdd.katas.stringcalculator;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hexad Spain on 09/03/2017.
 */
public class StringCalculatorTestUtils {
    static void assertResultEquals(String message, String test, int expectedResult) {
        int result = StringCalculator.calculate(test);
        assertEquals(message, expectedResult, result);
    }
}

package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;


/**
 * Feature #4: The calculate() method should be able to handle an unknown number of numbers
 */
@RunWith(Parameterized.class)
public class StringCalculatorFeature4Test {

    @Parameters(name = "{0}")
    public static Object[][] data() {
        return new Object[][] {
                {
                        "The calculate() method should be able to handle 0 numbers",
                        "",
                        0
                },
                {
                        "The calculate() method should be able to handle 3 numbers",
                        "1,2,3",
                        6
                },
                {
                        "The calculate() method should be able to handle 30 numbers",
                        "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30",
                        465
                }
        };
    }


    private String message;
    private String input;
    private int expectedResult;

    public StringCalculatorFeature4Test(String message, String input, int expectedResult) {
        this.message = message;
        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Test
    public void test() {
        StringCalculatorTestUtils.assertResultEquals(message, input, expectedResult);
    }

}

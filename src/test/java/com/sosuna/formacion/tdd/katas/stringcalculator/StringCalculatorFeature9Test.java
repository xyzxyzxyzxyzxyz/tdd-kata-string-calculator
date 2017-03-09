package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 * Feature #9: New long alternative separator definition format
 */
@RunWith(Parameterized.class)
public class StringCalculatorFeature9Test {

    @Parameters(name = "{0}")
    public static Object[][] data() {
        return new Object[][] {
                {
                        "Should accept input with long alternative separators",
                        "//[---]\n" + "1---2---3---4---5---6",
                        21
                },
                {
                        "Should accept input with default and long alternative separators",
                        "//[---]\n" + "1,2\n3---\n4,5\n6---7",
                        28
                }
        };
    }


    private String message;
    private String input;
    private int expectedResult;

    public StringCalculatorFeature9Test(String message, String input, int expectedResult) {
        this.message = message;
        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Test
    public void test() {
        StringCalculatorTestUtils.assertResultEquals(message, input, expectedResult);
    }

}

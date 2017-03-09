package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 * Feature #6: Alternative separator definition
 */
@RunWith(Parameterized.class)
public class StringCalculatorFeature6Test {

    @Parameters(name = "{0}")
    public static Object[][] data() {
        return new Object[][] {
                {
                        "Should accept input without alternative separator definition",
                        "1,2\n3,4\n5,6",
                        21
                },
                {
                        "Should accept input with alternative separator definition",
                        "//;\n" + "1;2;3;4;5;6",
                        21
                },
                {
                        "Should accept input with default and alternative separators",
                        "//;\n" + "1,2\n3;4,5\n6;7",
                        28
                }
        };
    }


    private String message;
    private String input;
    private int expectedResult;

    public StringCalculatorFeature6Test(String message, String input, int expectedResult) {
        this.message = message;
        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Test
    public void test() {
        StringCalculatorTestUtils.assertResultEquals(message, input, expectedResult);
    }

}

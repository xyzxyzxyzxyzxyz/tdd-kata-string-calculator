package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 * Feature #10: Multiple long alternative separators
 */
@RunWith(Parameterized.class)
public class StringCalculatorFeature10Test {

    @Parameters(name = "{0}")
    public static Object[][] data() {
        return new Object[][] {
                {
                        "Should accept input with single long alternative separator",
                        "//[---]\n" + "1,2\n3---4,5\n6---7",
                        28
                },
                {
                        "Should accept input with multiple long alternative separator",
                        "//[---][***]\n" + "1,2\n3---4***5,6\n7---8***9",
                        45
                }
        };
    }


    private String message;
    private String input;
    private int expectedResult;

    public StringCalculatorFeature10Test(String message, String input, int expectedResult) {
        this.message = message;
        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Test
    public void test() {
        StringCalculatorTestUtils.assertResultEquals(message, input, expectedResult);
    }

}

package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.runners.Parameterized.Parameters;


/**
 * Feature #7: Negative numbers should throw an exception
 */
public class StringCalculatorFeature7Test extends AbstractStringCalculatorParametrizedTest {

    @Parameters(name = "{0}")
    public static Object[][] data() {
        return new Object[][] {
                {
                        "One negative number should throw an exception",
                        "-1,2",
                        StringCalculator.NegativeNumbersException.class
                }
        };
    }

}

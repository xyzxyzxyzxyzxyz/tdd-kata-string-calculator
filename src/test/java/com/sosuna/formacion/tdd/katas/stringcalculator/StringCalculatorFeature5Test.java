package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.runners.Parameterized.Parameters;


/**
 * Feature #5: The newline character is also a number separator
 */
public class StringCalculatorFeature5Test extends AbstractStringCalculatorParametrizedTest {

    @Parameters(name = "{0}")
    public static Object[][] data() {
        return new Object[][] {
                {
                        "Should accept numbers separated only by commas",
                        "1,2,3",
                        6
                },
                {
                        "Should accept numbers separated only by newlines",
                        "1\n2\n3",
                        6
                },
                {
                        "Should accept numbers separated either by commas or newlines",
                        "1,2\n3,4\n5,6",
                        21
                }
        };
    }

}

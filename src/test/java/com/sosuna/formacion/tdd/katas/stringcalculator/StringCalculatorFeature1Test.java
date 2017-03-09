package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.runners.Parameterized.Parameters;


/**
 * Feature #1: Empty string should return 0
 */
public class StringCalculatorFeature1Test extends AbstractStringCalculatorParametrizedTest {

    @Parameters(name = "{0}")
    public static Object[][] data() {
        return new Object[][] {
                {
                        "Empty string should return 0",
                        "",
                        0
                }
        };
    }

}

package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.runners.Parameterized.Parameters;


/**
 * Feature #2: Single number should return that same number
 */
public class StringCalculatorFeature2Test extends AbstractStringCalculatorParametrizedTest {

    @Parameters(name = "{0}")
    public static Object[][] data() {
        return new Object[][] {
                {
                        "Single number should return that same number",
                        "1",
                        1
                }
        };
    }

}

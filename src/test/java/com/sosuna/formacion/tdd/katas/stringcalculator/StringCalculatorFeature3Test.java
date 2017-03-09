package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.runners.Parameterized.Parameters;


/**
 * Feature #3: Two numbers should return their sum
 */
public class StringCalculatorFeature3Test extends AbstractStringCalculatorParametrizedTest {

    @Parameters(name = "{0}")
    public static Object[][] data() {
        return new Object[][] {
                {
                        "Two numbers should return their sum",
                        "1,2",
                        3
                }
        };
    }

}

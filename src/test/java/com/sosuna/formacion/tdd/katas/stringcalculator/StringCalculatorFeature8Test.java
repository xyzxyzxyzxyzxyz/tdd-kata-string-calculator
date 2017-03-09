package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.runners.Parameterized.Parameters;


/**
 * Feature #8: Numbers bigger than 1000 should be ignored
 */
public class StringCalculatorFeature8Test extends AbstractStringCalculatorParametrizedTest {

    @Parameters(name = "{0}")
    public static Object[][] data() {
        return new Object[][] {
                {
                        "The three numbers bigger than 1000 should have been ignored",
                        "1,1001,2,2002,3,3003",
                        6
                }
        };
    }

}

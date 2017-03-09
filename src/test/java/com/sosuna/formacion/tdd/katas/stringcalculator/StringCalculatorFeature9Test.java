package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.runners.Parameterized.Parameters;


/**
 * Feature #9: New long alternative separator definition format
 */
public class StringCalculatorFeature9Test extends AbstractStringCalculatorParametrizedTest {

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
                        "//[---]\n" + "1,2\n3---4,5\n6---7",
                        28
                }
        };
    }

}

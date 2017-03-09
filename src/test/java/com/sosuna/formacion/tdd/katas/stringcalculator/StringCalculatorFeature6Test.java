package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.runners.Parameterized.Parameters;


/**
 * Feature #6: Alternative separator definition
 */
public class StringCalculatorFeature6Test extends AbstractStringCalculatorParametrizedTest {

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

}

package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.runners.Parameterized.Parameters;


/**
 * Feature #10: Multiple long alternative separators
 */
public class StringCalculatorFeature10Test extends AbstractStringCalculatorParametrizedTest {

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

}

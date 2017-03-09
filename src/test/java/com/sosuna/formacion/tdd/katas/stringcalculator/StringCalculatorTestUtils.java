package com.sosuna.formacion.tdd.katas.stringcalculator;

import static org.junit.Assert.*;

class StringCalculatorTestUtils {
    static void assertResultEquals(StringCalculator calculator, String message, String input, int expectedResult) {
        int result = calculator.calculate(input);
        assertEquals(message, expectedResult, result);
    }

    static void assertRaises(StringCalculator calculator, String message, String input, Class<? extends Throwable> expectedToRaise) {
        try {
            int result = calculator.calculate(input);
            fail(
                    (message!=null? (message + ". ") : "")
                    + "Expected to raise a Throwable of type ["+expectedToRaise.getName()+"], but returned with result ["+result+"]"
            );
        }
        catch (Throwable raised) {
            if (expectedToRaise.isAssignableFrom(raised.getClass())) {
                // Raised Throwable type matches with expected type
                // Test passes.
                return;
            }
            else {
                fail(
                        (message!=null? (message + ". ") : "")
                        + "Expected to raise a Throwable of type ["+expectedToRaise.getName()+"], but the type was  ["+raised.getClass().getName()+"]"
                );
            }
        }
    }
}

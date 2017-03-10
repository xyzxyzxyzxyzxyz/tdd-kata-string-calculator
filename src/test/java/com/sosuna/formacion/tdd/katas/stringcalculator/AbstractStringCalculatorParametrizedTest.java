package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


/**
 * Abstract parametrized test class.
 * For implementation of tests, extend it and declare a @Parameters method to
 * provide test data with the following signature:
 *
 * Example:
 *
        \@Parameters(name = "{0}")
        public static Object[][] data() {
            return new Object[][] {
                {
                    "Empty string should return 0",     // This is the test name
                    "",                                 // This is the test input
                    0                                   // This test should return normally with this result
                },
                {
                    "Negative numbers should raise an exception",       // This is the test name
                    "1,2,3",                                            // This is the test input
                    NegativeNumbersException.class                      // This test should raise an exception of type NegativeNumbersException
                }
            };
        }

 */
@RunWith(Parameterized.class)
public abstract class AbstractStringCalculatorParametrizedTest extends AbstractStringCalculatorTest {

    @Parameterized.Parameter(0)
    public String message;
    @Parameterized.Parameter(1)
    public String input;
    @Parameterized.Parameter(2)
    public Object expectedResult;

    @Test
    public void test() {
        if (expectedResult==null) {
            throw new IllegalArgumentException("Test must specify an expected result, either an integer or an exception class");
        }
        else if (expectedResult instanceof Integer) {
            StringCalculatorTestUtils.assertResultEquals(calculator, message, input, (Integer) expectedResult);
        }
        else if (expectedResult instanceof Class) {
            StringCalculatorTestUtils.assertRaises(calculator, message, input, (Class) expectedResult);
        }
        else {
            throw new IllegalArgumentException("Unexpected value for expectedResult. Type = ["+expectedResult.getClass().getName()+"]. Value = ["+expectedResult+"]");
        }
    }

}

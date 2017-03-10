package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.Test;

import static org.mockito.Mockito.verify;

/**
 * Feature #11: Logging
 */
public class StringCalculatorFeature11Test extends AbstractStringCalculatorTest {

    @Test
    public void calculatorShouldLogValidResults() {
        calculator.calculate("1,2,3");
        verify(logger).write("6");
    }

}

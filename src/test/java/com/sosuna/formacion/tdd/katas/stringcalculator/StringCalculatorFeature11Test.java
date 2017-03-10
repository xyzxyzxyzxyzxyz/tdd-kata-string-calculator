package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Feature #11: Logging
 */
public class StringCalculatorFeature11Test {

    private StringCalculator calculator;
    private ILogger logger;
    private ILoggerFailureNotificationWebService loggerFailWS;

    @Before
    public void setUp() {
        logger = mock(ILogger.class);
        loggerFailWS = mock(ILoggerFailureNotificationWebService.class);

        calculator = new StringCalculator(logger, loggerFailWS);
    }

    @Test
    public void calculatorShouldLogValidResults() {
        calculator.calculate("1,2,3");
        verify(logger).write("6");
    }

}

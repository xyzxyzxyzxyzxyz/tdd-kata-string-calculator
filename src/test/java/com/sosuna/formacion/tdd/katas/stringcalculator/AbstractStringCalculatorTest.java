package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.Before;

import static org.mockito.Mockito.mock;

/**
 * Common base class for tests around StringCalculator.
 * Mocks the direct dependencies of StringCalculator and readies them for verification.
 */
public class AbstractStringCalculatorTest {
    protected StringCalculator calculator;
    protected ILogger logger;
    protected ILoggerFailureNotificationWebService loggerFailWS;

    @Before
    public void setUp() {
        logger = mock(ILogger.class);
        loggerFailWS = mock(ILoggerFailureNotificationWebService.class);

        calculator = new StringCalculator(logger, loggerFailWS);
    }
}

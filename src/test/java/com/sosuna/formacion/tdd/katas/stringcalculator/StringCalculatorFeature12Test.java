package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Feature #12: Logging failure webservice
 */
public class StringCalculatorFeature12Test {

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
    public void calculatorShouldNotifyWebServiceWhenLoggingFails() {
        final String LOG_MESSAGE = "Error writing to log output";

        // Throw IOException when the logger is called to log the result
        doThrow(new RuntimeException(LOG_MESSAGE)).when(logger).write(anyString());

        calculator.calculate("1,2,3");

        // Expect the logger failure WS to be called with the exception message
        verify(loggerFailWS).notifyLoggingFailure(LOG_MESSAGE);
    }

}

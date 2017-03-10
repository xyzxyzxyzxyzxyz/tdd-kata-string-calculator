package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

/**
 * Feature #12: Logging failure webservice
 */
public class StringCalculatorFeature12Test extends AbstractStringCalculatorTest {

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

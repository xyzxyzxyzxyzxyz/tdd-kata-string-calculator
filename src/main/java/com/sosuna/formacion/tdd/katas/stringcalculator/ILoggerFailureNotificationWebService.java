package com.sosuna.formacion.tdd.katas.stringcalculator;

/**
 * This webservice is called when the StringCalculator tries to log
 * a calculation result via the ILogger interface and that interface
 * throws an exception.
 * The String calculator notifies the exception message via this interface
 */
public interface ILoggerFailureNotificationWebService {

    void notifyLoggingFailure(String message);

}

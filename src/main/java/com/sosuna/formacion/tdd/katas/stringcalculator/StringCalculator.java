package com.sosuna.formacion.tdd.katas.stringcalculator;

/**
 * TDD Kata:
 *      http://osherove.com/tdd-kata-1/
 */
public class StringCalculator {

    private ILogger logger;
    private ILoggerFailureNotificationWebService loggerFailWS;

    private StringCalculatorInputParser inputParser;
    private StringCalculatorEngine engine;

    public StringCalculator(ILogger logger, ILoggerFailureNotificationWebService loggerFailWS) {
        this.logger = logger;
        this.loggerFailWS = loggerFailWS;

        inputParser = new StringCalculatorInputParser();
        engine = new StringCalculatorEngine();
    }

    public int calculate(String input) throws NegativeNumbersException {
        // Obtain the numbers from the input data
        int[] numbers = inputParser.parseInput(input);
        // Calculate the sum
        int sum = engine.sumNumbers(numbers);
        // Display the result
        displayResult(sum);
        // Log the result
        logResult(sum);
        // Return the result
        return sum;
    }

    private void displayResult(int sum) {
        System.out.println(String.valueOf(sum));
    }

    private void logResult(int sum) {
        try {
            // Write the result to the log
            logger.write(String.valueOf(sum));
        }
        catch (Exception e) {
            // Logging failed. Send notification via the webservice.
            try {
                loggerFailWS.notifyLoggingFailure(e.getMessage());
            }
            catch (Exception e2) {
                // Ignore failures in the notification WS
            }
        }
    }

}

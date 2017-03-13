package com.sosuna.formacion.tdd.katas.stringcalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCalculatorCLI {

    private StringCalculator calculator;

    private BufferedReader systemInReader;

    StringCalculatorCLI(StringCalculator calculator) {
        this.calculator = calculator;

        systemInReader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Instance execution method, more friendly to
     * dependency injection
     *
     * @param args
     */
    public void runWithArgs(String... args) throws IOException {
        // Retrieve argument from command line
        String calculatorInput = args[0];
        // Remove surrounding '' from argument
        calculatorInput = calculatorInput.substring(1, calculatorInput.length()-1);

        while (!calculatorInput.isEmpty()) {
            // Execute calculator
            int result = calculator.calculate(calculatorInput);
            // Display result message
            System.out.println("The result is " + result);

            // Ask for more input
            System.out.println("Another input please");
            calculatorInput = systemInReader.readLine();
        }

    }

    /**
     * Static execution method that instantiates a CLI with
     * a default calculator and executes it with the input.
     *
     * @param args
     */
    public static void main(String... args) throws IOException {
        // Create calculator
        StringCalculator calculator = createCalculator();

        // Create calculator CLI
        StringCalculatorCLI cli = new StringCalculatorCLI(calculator);

        // Run CLI
        cli.runWithArgs(args);
    }

    private static StringCalculator createCalculator() {
        // Instantiate the calculator
        StringCalculator calculator = new StringCalculator(
                // Kata doesn't say where should we dump the log output
                new ILogger() {
                    @Override
                    public void write(String message) {
                        // NO-OP
                    }
                },
                // Kata doesn't say that we need to implement the webservice
                new ILoggerFailureNotificationWebService() {
                    @Override
                    public void notifyLoggingFailure(String message) {
                        // NO-OP
                    }
                }
        );

        return calculator;
    }

}

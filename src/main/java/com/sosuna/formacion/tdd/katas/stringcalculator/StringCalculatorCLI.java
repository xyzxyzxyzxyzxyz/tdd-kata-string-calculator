package com.sosuna.formacion.tdd.katas.stringcalculator;

public class StringCalculatorCLI {

    private StringCalculator calculator;

    StringCalculatorCLI(StringCalculator calculator) {
        this.calculator = calculator;
    }

    /**
     * Instance execution method, more friendly to
     * dependency injection
     *
     * @param args
     */
    public void runWithArgs(String... args) {
        // Retrieve argument from command line
        String calculatorInput = args[0];
        // Remove surrounding '' from argument
        calculatorInput = calculatorInput.substring(1, calculatorInput.length()-1);
        // Execute calculator
        int result = calculator.calculate(calculatorInput);
        // Display result message
        System.out.println("The result is " + result);
    }

    /**
     * Static execution method that instantiates a CLI with
     * a default calculator and executes it with the input.
     *
     * @param args
     */
    public static void main(String... args) {
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

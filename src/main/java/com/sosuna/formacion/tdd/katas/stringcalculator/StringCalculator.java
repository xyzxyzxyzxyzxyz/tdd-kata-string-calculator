package com.sosuna.formacion.tdd.katas.stringcalculator;

/**
 * TDD Kata:
 *      http://osherove.com/tdd-kata-1/
 */
public class StringCalculator {

    private StringCalculatorInputParser inputParser;
    private StringCalculatorEngine engine;

    public StringCalculator() {
        inputParser = new StringCalculatorInputParser();
        engine = new StringCalculatorEngine();
    }

    public int calculate(String input) throws NegativeNumbersException {
        // Obtain the numbers from the input data
        int[] numbers = inputParser.parseInput(input);
        // Calculate the sum
        int sum = engine.sumNumbers(numbers);
        // Return the result
        return sum;
    }

}

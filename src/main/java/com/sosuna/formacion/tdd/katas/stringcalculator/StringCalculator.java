package com.sosuna.formacion.tdd.katas.stringcalculator;

/**
 * TDD Kata:
 *      http://osherove.com/tdd-kata-1/
 */
public class StringCalculator {

    private StringCalculatorInputParser inputParser;

    public StringCalculator() {
        inputParser = new StringCalculatorInputParser();
    }

    public int calculate(String input) throws StringCalculatorInputParser.NegativeNumbersException {
        // Obtain the numbers from the input data
        int[] numbers = inputParser.parseInput(input);
        // Calculate the sum
        int sum = sumNumbers(numbers);
        // Return the result
        return sum;
    }



    private int sumNumbers(int[] numbers) {
        int sum = 0;

        // Sum all the numbers.
        // Numbers bigger than 1000 will be ignored
        for (int number :  numbers) {
            // Ignore numbers bigger than 1000
            if (number <= 1000) {
                sum += number;
            }
        }

        return sum;
    }

}

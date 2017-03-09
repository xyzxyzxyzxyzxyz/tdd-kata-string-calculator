package com.sosuna.formacion.tdd.katas.stringcalculator;

/**
 * TDD Kata:
 *      http://osherove.com/tdd-kata-1/
 */
public class StringCalculator {

    public static int calculate(String input) {
        int[] numbers = parseNumbers(input);
        int sum = sumNumbers(numbers);
        return sum;
    }

    private static int[] parseNumbers(String input) {
        if (input.length()==0) {
            return new int[0];
        }

        String[] numberTokens = input.split("[,\n]");
        int[] numbers = new int[numberTokens.length];

        for (int i=0; i<numberTokens.length; i++) {
            numbers[i] = Integer.parseInt(numberTokens[i]);
        }

        return numbers;
    }

    private static int sumNumbers(int[] numbers) {
        int sum = 0;

        for (int i=0; i<numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }

}

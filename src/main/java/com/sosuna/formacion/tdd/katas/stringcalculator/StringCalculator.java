package com.sosuna.formacion.tdd.katas.stringcalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * TDD Kata:
 *      http://osherove.com/tdd-kata-1/
 */
public class StringCalculator {

    public static int calculate(String input) throws NegativeNumbersException {
        String[] parsedInput = parseInput(input);
        String altSeparator = parsedInput[0];
        String numbersList = parsedInput[1];

        int[] numbers = parseNumbers(altSeparator, numbersList);
        int sum = sumNumbers(numbers);
        return sum;
    }

    private static String[] parseInput(String input) {
        String altSeparator = parseAltSeparator(input);
        String numbersList = parseNumbersList(input);

        return new String[] { altSeparator, numbersList };
    }

    private static String parseAltSeparator(String input) {
        // Check for alternate separator definition in input
        if (!input.startsWith("//")) {
            // No alternate separator definition in input
            return null;
        }

        // Extract alternate separator
        // From "//" to "\n", not inclusive
        String altSeparator = input.substring(2, input.indexOf('\n'));
        return altSeparator;
    }

    private static String parseNumbersList(String input) {
        // Check for alternate separator definition in input
        if (input.startsWith("//")) {
            // Skip alternate separator definition in input
            input = input.substring(input.indexOf('\n')+1);
        }

        return input;
    }

    private static int[] parseNumbers(String altSeparator, String numbersList) throws NegativeNumbersException {
        // Split the tokens using the default and alternative separators
        String[] numberTokens =  splitNumbersList(altSeparator, numbersList);

        // Parse the numbers from the tokens
        // If there are negative numbers in the list, store them in an additional list

        int[] numbers = new int[numberTokens.length];
        List<Integer> negativeNumbers = new ArrayList<Integer>();

        for (int i=0; i<numberTokens.length; i++) {
            // Parse number
            numbers[i] = Integer.parseInt(numberTokens[i]);
            // If negative, add to negatives' list
            if (numbers[i]<0) {
                negativeNumbers.add(numbers[i]);
            }
        }

        // If there are negative numbers, throw an error
        if (negativeNumbers.size()>0) {
            throw new NegativeNumbersException(negativeNumbers);
        }

        // No negatives, return the numbers list
        return numbers;
    }

    private static String[] splitNumbersList(String altSeparator, String numbersList) {
        // If numbers list is empty, return 0
        if (numbersList.length()==0) {
            return new String[0];
        }

        // Default separator
        String splittingRegex = "[,\n]";

        if (altSeparator != null) {
            splittingRegex += ("|(\\Q"+altSeparator+"\\E)");
        }

        String[] tokens = numbersList.split(splittingRegex);

        return tokens;
    }

    private static int sumNumbers(int[] numbers) {
        int sum = 0;

        for (int i=0; i<numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }

    /**
     * Negative numbers error
     */
    public static final class NegativeNumbersException extends IllegalArgumentException {

        private NegativeNumbersException(List<Integer> negativeNumbers) {
            super("List has negative numbers: ["+negativeNumbers.toString()+"]");
        }

    }
}

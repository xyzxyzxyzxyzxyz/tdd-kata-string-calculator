package com.sosuna.formacion.tdd.katas.stringcalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * TDD Kata:
 *      http://osherove.com/tdd-kata-1/
 */
public class StringCalculator {

    public static int calculate(String input) throws NegativeNumbersException {
        ParsedInputData parsedInput = parseInput(input);

        int[] numbers = parseNumbers(parsedInput);
        int sum = sumNumbers(numbers);
        return sum;
    }

    private static ParsedInputData parseInput(String input) {
        ParsedInputData data = new ParsedInputData();

        data.altSeparators = parseAltSeparators(input);
        data.numbersList = parseNumbersList(input);

        return data;
    }

    private static String[] parseAltSeparators(String input) {
        // TODO: Parse multiple separators

        // Check for alternate separator definition in input
        if (!input.startsWith("//")) {
            // No alternate separator definition in input
            return null;
        }

        // Extract alternate separator

        // From "//" to "\n", not inclusive
        String altSeparator = input.substring(2, input.indexOf('\n'));

        // If the alternate separator has the form "[xxx]", it's in the long format.
        // Remove the brackets around it and leave "xxx"
        if (altSeparator.startsWith("[") && altSeparator.endsWith("]")) {
            altSeparator = altSeparator.substring(1, altSeparator.length()-1);
        }

        return new String[] { altSeparator };
    }

    private static String parseNumbersList(String input) {
        // Check for alternate separator definition in input
        if (input.startsWith("//")) {
            // Skip alternate separator definition in input
            input = input.substring(input.indexOf('\n')+1);
        }

        return input;
    }

    private static int[] parseNumbers(ParsedInputData parsedInput) throws NegativeNumbersException {
        // Split the tokens using the default and alternative separators
        String[] numberTokens =  splitNumbersList(parsedInput);

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

    private static String[] splitNumbersList(ParsedInputData parsedInput) {
        // If numbers list is empty, return 0
        if (parsedInput.numbersList.length()==0) {
            return new String[0];
        }

        // Default separators
        String splittingRegex = "[,\n]";

        // TODO: Process multiple separators
        String altSeparator = parsedInput.altSeparators==null ? null : parsedInput.altSeparators[0];

        if (altSeparator != null) {
            splittingRegex += ("|(\\Q"+altSeparator+"\\E)");
        }

        String[] tokens = parsedInput.numbersList.split(splittingRegex);

        return tokens;
    }

    private static int sumNumbers(int[] numbers) {
        int sum = 0;

        // Sum all the numbers.
        // Numbers bigger than 1000 will be ignored
        for (int i=0; i<numbers.length; i++) {
            // Ignore numbers bigger than 1000
            if (numbers[i] <= 1000) {
                sum += numbers[i];
            }
        }

        return sum;
    }

    /**
     * Negative numbers error
     */
    public static class NegativeNumbersException extends IllegalArgumentException {

        private NegativeNumbersException(List<Integer> negativeNumbers) {
            super("List has negative numbers: ["+negativeNumbers.toString()+"]");
        }

    }

    private static class ParsedInputData {
        public String[] altSeparators;
        public String numbersList;
    }
}

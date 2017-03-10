package com.sosuna.formacion.tdd.katas.stringcalculator;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringCalculatorInputParser {

    public int[] parseInput(String input) {
        // Parse the input data
        ParsedInputData parsedInput = parseInputData(input);
        // Parse the numbers from the input data
        int[] numbers = parseNumbers(parsedInput);
        // Return the parsed numbers
        return numbers;
    }

    private ParsedInputData parseInputData(String input) {
        ParsedInputData data = new ParsedInputData();

        data.altSeparators = parseAltSeparators(input);
        data.numbersList = parseNumbersList(input);

        return data;
    }

    private String[] parseAltSeparators(String input) {
        // Check for alternate separators definition in input
        if (!input.startsWith("//")) {
            // No alternate separators definition in input
            return null;
        }

        // Extract alternate separators

        // From "//" to "\n", not inclusive
        String altSeparatorsSpec = input.substring(2, input.indexOf('\n'));

        // If the separators spec is in the multiple-and-long format, parse it as such
        if (isMultipleLongAltSeparatorsSpec(altSeparatorsSpec)) {
            return parseMultipleLongAltSeparatorsSpec(altSeparatorsSpec);
        }
        // Otherwise parse it as a single separator
        else {
            return parseSingleAltSeparatorSpec(altSeparatorsSpec);
        }
    }

    private String[] parseSingleAltSeparatorSpec(String altSeparatorsSpec) {
        return new String[] { altSeparatorsSpec };
    }

    private boolean isMultipleLongAltSeparatorsSpec(String altSeparatorsSpec) {
        return altSeparatorsSpec.startsWith("[") && altSeparatorsSpec.endsWith("]");
    }

    private static final Pattern MULTI_LONG_ALT_SEP_PATTERN = Pattern.compile("\\[([^\\]]+)\\]");
    private String[] parseMultipleLongAltSeparatorsSpec(String altSeparatorsSpec) {
        Matcher m = MULTI_LONG_ALT_SEP_PATTERN.matcher(altSeparatorsSpec);

        // Unrepeated alt separators
        Set<String> altSeparators = new HashSet<>();

        // Parse all separators
        String separator;
        while (m.find()) {
            // Get the next separator, without []
            separator = m.group(1);
            // Add it to set if not empty
            if (separator.length()>0) {
                altSeparators.add(separator);
            }
        }

        // No separators, return null
        if (altSeparators.size()==0) {
            return null;
        }

        // Some separators, return as array
        return altSeparators.toArray(new String[altSeparators.size()]);
    }

    private String parseNumbersList(String input) {
        // Check for alternate separator definition in input
        if (input.startsWith("//")) {
            // Skip alternate separator definition in input
            input = input.substring(input.indexOf('\n')+1);
        }

        return input;
    }

    private int[] parseNumbers(ParsedInputData parsedInput) throws NegativeNumbersException {
        // Split the tokens using the default and alternative separators
        String[] numberTokens =  splitNumbersList(parsedInput);

        // Parse the numbers from the tokens

        int[] numbers = new int[numberTokens.length];

        for (int i=0; i<numberTokens.length; i++) {
            // Parse number
            numbers[i] = Integer.parseInt(numberTokens[i]);
        }

        // Return the numbers list
        return numbers;
    }

    private String[] splitNumbersList(ParsedInputData parsedInput) {
        // If numbers list is empty, return 0
        if (parsedInput.numbersList.length()==0) {
            return new String[0];
        }

        // Build splitting regex from default and alternative separators
        String splittingRegex = buildSplittingRegex(parsedInput);

        // Split numbers list with the splitting regex to get the separate numbers
        String[] tokens = parsedInput.numbersList.split(splittingRegex);

        // Return the split number tokens
        return tokens;
    }

    private String buildSplittingRegex(ParsedInputData parsedInput) {
        // Define default separators
        StringBuilder splittingRegex = new StringBuilder("[,\n]");

        // If alt separators defined, expand regex for them
        if (parsedInput.altSeparators != null) {
            // Process each alt separator
            for (String altSeparator : parsedInput.altSeparators) {
                // Expand splitting regex with regex for new alt separator
                splittingRegex.append("|(\\Q"+altSeparator+"\\E)");
            }
        }

        // Return splitting regex
        return splittingRegex.toString();
    }

    private static class ParsedInputData {
        String[] altSeparators;
        String numbersList;
    }

}

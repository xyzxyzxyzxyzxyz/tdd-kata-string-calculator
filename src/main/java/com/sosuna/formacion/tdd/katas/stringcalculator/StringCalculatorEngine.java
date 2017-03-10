package com.sosuna.formacion.tdd.katas.stringcalculator;

import java.util.ArrayList;
import java.util.List;

class StringCalculatorEngine {

    public int sumNumbers(int[] numbers) throws NegativeNumbersException {
        int sum = 0;

        // Sum all the numbers.
        // Numbers bigger than 1000 will be ignored
        // If there are negative numbers in the list, store them in an additional list
        for (int number :  numbers) {
            // Ignore numbers bigger than 1000
            if (number <= 1000) {
                sum += number;
            }
            // If there are negative numbers, throw an error
            if (number<0) {
                throwNegativeNumbersException(numbers);
            }
        }

        return sum;
    }

    private void throwNegativeNumbersException(int[] numbers) throws NegativeNumbersException {
        List<Integer> negativeNumbers = new ArrayList<>();

        for (int number : numbers) {
            // If negative, add to negatives' list
            if (number<0) {
                negativeNumbers.add(number);
            }
        }

        // If there are negative numbers, throw an error
        if (negativeNumbers.size()>0) {
            throw new NegativeNumbersException(negativeNumbers);
        }
        else {
            throw new IllegalStateException("Should have found at least a negative number. Found none.");
        }
    }

}

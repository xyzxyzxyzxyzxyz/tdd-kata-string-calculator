package com.sosuna.formacion.tdd.katas.stringcalculator;

/**
 * Created by Hexad Spain on 10/03/2017.
 */
class StringCalculatorEngine {

    public int sumNumbers(int[] numbers) {
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

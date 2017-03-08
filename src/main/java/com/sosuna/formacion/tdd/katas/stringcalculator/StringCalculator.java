package com.sosuna.formacion.tdd.katas.stringcalculator;

/**
 * TDD Kata:
 *      http://osherove.com/tdd-kata-1/
 */
public class StringCalculator {

    public static int calculate(String input) {
        if (input.length()==0) {
            return 0;
        }
        else if (input.contains(",")) {
            String[] numbers = input.split(",");

            int number1 = Integer.parseInt(numbers[0]);
            int number2 = Integer.parseInt(numbers[1]);
            int number3 = Integer.parseInt(numbers[2]);

            return number1 + number2 + number3;
        }
        else {
            return Integer.parseInt(input);
        }
    }

}

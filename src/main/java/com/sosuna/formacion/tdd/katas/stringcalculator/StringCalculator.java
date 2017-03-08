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
        else {
            return Integer.parseInt(input);
        }
    }

}

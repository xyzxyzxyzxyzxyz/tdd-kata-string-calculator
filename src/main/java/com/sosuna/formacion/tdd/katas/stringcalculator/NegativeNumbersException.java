package com.sosuna.formacion.tdd.katas.stringcalculator;

import java.util.List;

/**
 * Negative numbers error
 */
public class NegativeNumbersException extends IllegalArgumentException {

    NegativeNumbersException(List<Integer> negativeNumbers) {
        super("List has negative numbers: ["+negativeNumbers.toString()+"]");
    }

}

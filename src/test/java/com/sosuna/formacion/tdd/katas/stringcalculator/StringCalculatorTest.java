package com.sosuna.formacion.tdd.katas.stringcalculator;


import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class StringCalculatorTest {




    //@Test
    public void testTemplate() {
        String test = "XXXX";
        int expectedResult = -1;

        int result = StringCalculator.calculate(test);
        assertEquals("DESCRIPTION", expectedResult, result);
    }

}

package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StringCalculatorFeature14Test {

    @Rule
    public final SystemOutRule consoleOutput = new SystemOutRule().enableLog();

    private StringCalculator calculator;
    private StringCalculatorCLI cli;

    @Before
    public void setUp() throws Exception {
        // Mock the calculator
        calculator = mock(StringCalculator.class);
        // Build CLI with mock calculator
        cli = new StringCalculatorCLI(calculator);
    }

    @Test
    public void executingProgramWithInput123ShouldCallCalculatorAndPrintOutMessageWithResult() throws Exception {
        // Mock calculator behaviour
        final String CALC_IN = "1,2,3";
        final int CALC_OUT = 6;
        when(calculator.calculate(CALC_IN)).thenReturn(CALC_OUT);

        /*
            Run CLI with input
            Though the program executes with the static "main" execution
            method, that method simply instantiates a CLI instance and
            executes the runWithArgs() instance method.
            Thus, we can assume that testing the instance execution method we
            are also testing the static execution method.
         */
        cli.runWithArgs("'"+CALC_IN+"'");

        // Verify calculator has been called appropriately
        verify(calculator).calculate(CALC_IN);

        // Compare expected vs actual output
        assertConsoleOutputEquals("The result is " + CALC_OUT);
    }



    private void assertConsoleOutputEquals(String expectedConsoleOutputLineContent) {
        String expectedConsoleOutput = expectedConsoleOutputLineContent + System.lineSeparator();
        String actualConsoleOutput = consoleOutput.getLog();

        assertEquals("Console output should match with expectations", expectedConsoleOutput, actualConsoleOutput);
    }
}

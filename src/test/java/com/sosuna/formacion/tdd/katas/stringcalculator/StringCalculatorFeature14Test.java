package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

public class StringCalculatorFeature14Test {

    @Rule
    public final SystemOutRule consoleOutput = new SystemOutRule().enableLog();

    private StringCalculatorCLI cli;

    @Before
    public void setUp() throws Exception {
         cli = new StringCalculatorCLI();
    }

    @Test
    public void executingProgramWithInput123ShouldPrintOutMessageWithResult6() throws Exception {
        cli.runWithArgs("'1,2,3'");
        assertConsoleOutputEquals("The result is 6");
    }




    private void assertConsoleOutputEquals(String expectedConsoleOutputLineContent) {
        String expectedConsoleOutput = expectedConsoleOutputLineContent + System.lineSeparator();
        String actualConsoleOutput = consoleOutput.getLog();

        assertEquals("Console output should match with expectations", expectedConsoleOutput, actualConsoleOutput);
    }
}

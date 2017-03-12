package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.Test;

/**
 * Feature #13: Console output
 *
 * Abstract class with the test structure.
 * There are several ways to check the console output.
 * Subclasses of this one experiment the different ways.
 */
public abstract class StringCalculatorFeature13Test extends AbstractStringCalculatorTest {

    @Test
    public void calculatorShouldShowResultOnConsoleOutput() throws Throwable {
        calculator.calculate("1,2,3");

        assertConsoleOutputLineContentEquals("6");
    }

    /**
     * @param consoleOutputLineContent
     *      The console outputted line content, without the trailing newline sequence
     */
    protected abstract void assertConsoleOutputLineContentEquals(String consoleOutputLineContent) throws Throwable;

}

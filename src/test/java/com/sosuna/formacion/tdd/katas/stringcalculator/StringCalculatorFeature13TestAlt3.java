package com.sosuna.formacion.tdd.katas.stringcalculator;


import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

/**
 * Feature #13: Console output
 *
 * Console output intercepted using the SystemOutRule from org.junit.contrib
 *
 * FRAGILE???
 *      - Is the SystemOut Not thread-safe?? System.out is modified while running this test. This can interfere with other tests running.
 *      - Not thread-safe?? System.out could have been set to a mock by another concurrently running test.
 *      
 */
public class StringCalculatorFeature13TestAlt3 extends StringCalculatorFeature13Test {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Override
    protected void assertConsoleOutputLineContentEquals(String expectedConsoleOutputLineContent) throws Throwable {
        // Add line separator to expected
        String expectedConsoleOutput = expectedConsoleOutputLineContent + System.lineSeparator();
        // Get System.out output
        String actualConsoleOutput = systemOutRule.getLog();
        // Check
        assertEquals("Console output does not match expectations", expectedConsoleOutput, actualConsoleOutput);
    }

}

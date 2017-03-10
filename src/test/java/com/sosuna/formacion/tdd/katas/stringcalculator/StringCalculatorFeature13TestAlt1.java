package com.sosuna.formacion.tdd.katas.stringcalculator;


import org.junit.After;
import org.junit.Before;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * Feature #13: Console output
 *
 * Console output intercepted by replacing System.out with a mock.
 *
 * FRAGILE!!!
 *      - Verification done assuming StringCalculator is using the method System.out.println()
 *      - Not thread-safe! System.out is modified while running this test. This can interfere with other tests running.
 *      - Not thread-safe! System.out could have been set to a mock by another concurrently running test.
 *      
 */
public class StringCalculatorFeature13TestAlt1 extends StringCalculatorFeature13Test {

    private PrintStream previousSystemOut = null;

    @Override
    @Before
    public void setUp() {
        super.setUp();

        // Backup real System.out
        previousSystemOut = System.out;
        // Create and set a mock for System.out
        System.setOut(mock(PrintStream.class));
    }

    @After
    public void tearDown() {
        System.setOut(previousSystemOut);
    }

    @Override
    protected void assertConsoleOutputLineContentEquals(String consoleOutputLineContent) {
        verify(System.out).println(consoleOutputLineContent);
    }

}

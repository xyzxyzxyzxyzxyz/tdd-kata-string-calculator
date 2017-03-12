package com.sosuna.formacion.tdd.katas.stringcalculator;


import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Feature #13: Console output
 *
 * Console output intercepted by replacing System.out.writer() with a mock.
 *
 * FRAGILE!!!
 *      - Not thread-safe?? System.out is modified while running this test. This can interfere with other tests running.
 *      - Not thread-safe?? System.out could have been set to a mock by another concurrently running test.
 *      
 */
public class StringCalculatorFeature13TestAlt2 extends StringCalculatorFeature13Test {

    private PrintStream previousSystemOut = null;

    private ByteArrayOutputStream internalBuffer;

    @Override
    @Before
    public void setUp() {
        super.setUp();

        // Backup real System.out
        previousSystemOut = System.out;
        // Create and set a mock PrintStream for System.out
        internalBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(internalBuffer));
    }

    @After
    public void tearDown() {
        System.setOut(previousSystemOut);
    }

    @Override
    protected void assertConsoleOutputLineContentEquals(String consoleOutputLineContent) throws Throwable {
        // Add line separator
        String expectedConsoleOutput = consoleOutputLineContent + System.lineSeparator();
        // Convert to bytes in the platform's default charset
        byte[] expectedConsoleOutputBytes = expectedConsoleOutput.getBytes();

        // Retrieve actual console output bytes from the fake System.out
        byte[] actualConsoleOutputBytes = internalBuffer.toByteArray();
        // Check
        assertArrayEquals("Console output does not match expectations", expectedConsoleOutputBytes, actualConsoleOutputBytes);
    }

}

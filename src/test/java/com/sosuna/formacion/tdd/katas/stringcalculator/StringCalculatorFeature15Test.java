package com.sosuna.formacion.tdd.katas.stringcalculator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class StringCalculatorFeature15Test {

    @Rule
    public final SystemOutRule consoleOutput = new SystemOutRule();
    @Rule
    public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();


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
    public void executingProgramWithCLIArgsAndInputArgsShouldCallCalculatorAndPrintOutMessagesWithResults() throws Exception {

        final String    CLI_OP__ARGS = "'1,2,3'";
        final String    CLI_OP__EXPECTED_CALCULATOR_INPUT = "1,2,3";
        final int       CLI_OP__CALCULATOR_OUTPUT = 6;
        final String    CLI_OP__EXPECTED_CONSOLE_OUTPUT =
                "The result is 6" + System.lineSeparator() +
                "Another input please" + System.lineSeparator();

        final String    INTERACTIVE_OP1__CONSOLE_INPUT = "4,5,6";
        final String    INTERACTIVE_OP1__EXPECTED_CALCULATOR_INPUT = "4,5,6";
        final int       INTERACTIVE_OP1__CALCULATOR_OUTPUT = 15;
        final String    INTERACTIVE_OP1__EXPECTED_CONSOLE_OUTPUT =
                "The result is 15" + System.lineSeparator() +
                "Another input please" + System.lineSeparator();

        final String    INTERACTIVE_OP2__CONSOLE_INPUT = "7,8,9";
        final String    INTERACTIVE_OP2__EXPECTED_CALCULATOR_INPUT = "7,8,9";
        final int       INTERACTIVE_OP2__CALCULATOR_OUTPUT = 24;
        final String    INTERACTIVE_OP2__EXPECTED_CONSOLE_OUTPUT =
                "The result is 24" + System.lineSeparator() +
                "Another input please" + System.lineSeparator();

        final String    INTERACTIVE_EXIT__CONSOLE_INPUT = "";
        final String    INTERACTIVE_EXIT__EXPECTED_CONSOLE_OUTPUT = "";     // The program doesn't print out anything when whe exit


        // Prepare the mock calculator behaviour

        // First calculator input (from command line args)
        when(calculator.calculate(CLI_OP__EXPECTED_CALCULATOR_INPUT))
                .thenReturn(CLI_OP__CALCULATOR_OUTPUT);
        // Second calculator input (from interactive user input)
        when(calculator.calculate(INTERACTIVE_OP1__EXPECTED_CALCULATOR_INPUT))
                .thenReturn(INTERACTIVE_OP1__CALCULATOR_OUTPUT);
        // Third calculator input (from interactive user input)
        when(calculator.calculate(INTERACTIVE_OP2__EXPECTED_CALCULATOR_INPUT))
                .thenReturn(INTERACTIVE_OP2__CALCULATOR_OUTPUT);

        // Accumulate the standard input for all the successive tests
        systemInMock.provideLines(
                INTERACTIVE_OP1__CONSOLE_INPUT,
                INTERACTIVE_OP2__CONSOLE_INPUT,
                INTERACTIVE_EXIT__CONSOLE_INPUT
        );

        // Launch the calculator CLI with arguments
        // The first calculation is done with the input provided by the command line arguments
        consoleOutput.enableLog();  // Capture output
        cli.runWithArgs(CLI_OP__ARGS);
        consoleOutput.mute();       // Stop capture

        // Verify interactions with mock calculator
        verify(calculator, times(1)).calculate(CLI_OP__EXPECTED_CALCULATOR_INPUT);
        verify(calculator, times(1)).calculate(INTERACTIVE_OP1__EXPECTED_CALCULATOR_INPUT);
        verify(calculator, times(1)).calculate(INTERACTIVE_OP2__EXPECTED_CALCULATOR_INPUT);

        // Assert console output was as expected
        String actualConsoleOutput = consoleOutput.getLog();
        String expectedConsoleOutput =
                        CLI_OP__EXPECTED_CONSOLE_OUTPUT +
                        INTERACTIVE_OP1__EXPECTED_CONSOLE_OUTPUT +
                        INTERACTIVE_OP2__EXPECTED_CONSOLE_OUTPUT +
                        INTERACTIVE_EXIT__EXPECTED_CONSOLE_OUTPUT;
        assertEquals(
                "Console output should be the accumulation of the expected console output for all operations",
                expectedConsoleOutput,
                actualConsoleOutput
        );

    }

}

package com.merigasparyan.jmp.Task5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTest{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    public void testANumberWithPositiveValue() {
        int input = 5;

        Number.aNumber(input);

        String expectedOutput = "second string" + System.lineSeparator() +
                "third string" + System.lineSeparator();

        assertEquals(expectedOutput, outContent.toString());
    }

}

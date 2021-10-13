package ru.otus.numberInWords.logic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ProgramTest {

    private ByteArrayOutputStream byteArrayOutputStream;
    private ByteArrayInputStream byteArrayInputStream;
    private static final PrintStream OLD_STATEMENT_OF_STREAM = System.out;

    @BeforeEach
    void changeOutStream(){
        byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        byteArrayInputStream = new ByteArrayInputStream("1".getBytes());
        System.setIn(byteArrayInputStream);
    }

//
//    @AfterEach
//    void returnOutputStreamToDefaultStatement(){
//        System.setOut(OLD_STATEMENT_OF_STREAM);
//        System.setIn(System.in);
//    }





    @Test
    void startProgramTest() {

//        byteArrayOutputStream = new ByteArrayOutputStream();
//        PrintStream printStream = new PrintStream(byteArrayOutputStream);
//        System.setOut(printStream);
//
//        byteArrayInputStream = new ByteArrayInputStream("1".getBytes());
//        System.setIn(byteArrayInputStream);

        new Program().start();
        String expected = "один рубль ";
        String actual = byteArrayOutputStream.toString();


        assertEquals(expected, actual);
    }
}
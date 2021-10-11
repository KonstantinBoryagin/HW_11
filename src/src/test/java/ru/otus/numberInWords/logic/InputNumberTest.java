package ru.otus.numberInWords.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class InputNumberTest {
    static InputNumber testNumber1;
    static InputNumber testNumber2;
    static InputNumber testNumber3;
    static InputNumber testNumber4;
    static InputNumber testNumber5;

    @BeforeAll
    static void init(){
        testNumber1 = new InputNumber(56_123_954_353_451.19);
        testNumber2 = new InputNumber(-678_954_353_412.1);
        testNumber3 = new InputNumber(353_452.01);
        testNumber4 = new InputNumber(-456.02);
        testNumber5 = new InputNumber(96_456);
    }

    @Test
    void TestGetPennyIndexForNumber1() {
        int actual = 2;
        int expected = testNumber1.getPennyIndex();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetPennyIndexForNumber2() {
        int actual = 2;
        int expected = testNumber2.getPennyIndex();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetPennyIndexForNumber3() {
        int actual = 0;
        int expected = testNumber3.getPennyIndex();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetPennyIndexForNumber4() {
        int actual = 1;
        int expected = testNumber4.getPennyIndex();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetPennyIndexForNumberNotEquals() {
        int actual = 0;
        int expected = testNumber5.getPennyIndex();
        assertNotEquals(expected, actual);
    }

    @Test
    void TestGetFractionalPartOfNumber1() {
        long actual = 19;
        long expected = testNumber1.getFractionalPartOfNumber();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetFractionalPartOfNumber2() {
        long actual = 10;
        long expected = testNumber2.getFractionalPartOfNumber();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetFractionalPartOfNumber3() {
        long actual = 1;
        long expected = testNumber3.getFractionalPartOfNumber();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetFractionalPartOfNumber4() {
        long actual = 2;
        long expected = testNumber4.getFractionalPartOfNumber();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetFractionalPartOfNumberNotEquals() {
        long actual = 1;
        long expected = testNumber4.getFractionalPartOfNumber();
        assertNotEquals(expected, actual);
    }

    @Test
    void TestGetNumberLength1() {
        int actual = 14;
        int expected = testNumber1.getNumberLength();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetNumberLength2() {
        int actual = 12;
        int expected = testNumber2.getNumberLength();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetNumberLength3() {
        int actual = 6;
        int expected = testNumber3.getNumberLength();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetNumberLength4() {
        int actual = 3;
        int expected = testNumber4.getNumberLength();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetFractionalPartLength1() {
        int actual = 2;
        int expected = testNumber1.getFractionalPartLength();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetFractionalPartLength2() {
        int actual = 1;
        int expected = testNumber2.getFractionalPartLength();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetFractionalPartLength3() {
        int actual = 0;
        int expected = testNumber5.getFractionalPartLength();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetCurrencyIndex1() {
        int actual = 0;
        int expected = testNumber1.getCurrencyIndex();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetCurrencyIndex2() {
        int actual = 2;
        int expected = testNumber2.getCurrencyIndex();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetCurrencyIndex3() {
        int actual = 1;
        int expected = testNumber3.getCurrencyIndex();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetCurrencyIndexNotEquals() {
        int actual = 1;
        int expected = testNumber5.getCurrencyIndex();
        assertNotEquals(expected, actual);
    }

    @Test
    void TestGetWholePartOfNumber1() {
        long actual = 56_123_954_353_451L;
        long expected = testNumber1.getWholePartOfNumber();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetWholePartOfNumber2() {
        long actual = 678_954_353_412L;
        long expected = testNumber2.getWholePartOfNumber();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetWholePartOfNumber3() {
        long actual = 353_452L;
        long expected = testNumber3.getWholePartOfNumber();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetWholePartOfNumber4() {
        long actual = 96_456L;
        long expected = testNumber5.getWholePartOfNumber();
        assertEquals(expected, actual);
    }

    @Test
    void TestGetWholePartOfNumberNotEquals() {
        long actual = 56_123_954_353_451L;
        long expected = testNumber4.getWholePartOfNumber();
        assertNotEquals(expected, actual);
    }
}
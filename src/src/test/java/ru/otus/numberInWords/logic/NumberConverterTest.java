package ru.otus.numberInWords.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberConverterTest {
    static InputNumber testNumber1;
    static InputNumber testNumber2;
    static InputNumber testNumber3;
    static InputNumber testNumber4;
    static InputNumber testNumber5;
    static InputNumber testNumber6;
    static InputNumber testNumber7;
    NumberConverter numberConverter = new NumberConverter();

    @BeforeAll
    static void initializeNumber(){
        testNumber1 = new InputNumber(56_123_954_353_451.19);
        testNumber2 = new InputNumber(-678_954_353_412.1);
        testNumber3 = new InputNumber(353_452.01);
        testNumber4 = new InputNumber(-456.02);
        testNumber5 = new InputNumber(96_456);
        testNumber6 = new InputNumber(-981_232_346_512_234L);
        testNumber7 = new InputNumber(-0.9);
    }

    @BeforeEach
    void init(){

    }

    @Test
    void TestConvertingNumberToString1() {
        String actual = "пятьдесят шесть триллионов сто двадцать три миллиарда девятьсот пятьдесят четыре миллиона " +
                "триста пятьдесят три тысячи четыреста пятьдесят один рубль" +
                " и девятнадцать копеек";
        String expected = numberConverter.convertingNumberToString(testNumber1);
        assertEquals(expected, actual);
    }

    @Test
    void TestConvertingNumberToString2() {
        String actual = "минус шестьсот семьдесят восемь миллиардов девятьсот пятьдесят четыре миллиона " +
                "триста пятьдесят три тысячи четыреста двенадцать рублей и десять копеек";
        String expected = numberConverter.convertingNumberToString(testNumber2);
        assertEquals(expected, actual);
    }

    @Test
    void TestConvertingNumberToString3() {
        String actual = "триста пятьдесят три тысячи четыреста пятьдесят два рубля и одна копейка";
        String expected = numberConverter.convertingNumberToString(testNumber3);
        assertEquals(expected, actual);
    }

    @Test
    void TestConvertingNumberToString4() {
        String actual = "минус четыреста пятьдесят шесть рублей и две копейки";
        String expected = numberConverter.convertingNumberToString(testNumber4);
        assertEquals(expected, actual);
    }

    @Test
    void TestConvertingNumberToString5() {
        String actual = "девяносто шесть тысяч четыреста пятьдесят шесть рублей ";
        String expected = numberConverter.convertingNumberToString(testNumber5);
        assertEquals(expected, actual);
    }

    @Test
    void TestConvertingNumberToString6() {
        String actual = "минус девятьсот восемьдесят один триллион двести тридцать два миллиарда триста сорок шесть миллионов" +
                " пятьсот двенадцать тысяч двести тридцать четыре рубля ";
        String expected = numberConverter.convertingNumberToString(testNumber6);
        assertEquals(expected, actual);
    }
    @Test
    void TestConvertingNumberToString7() {
        String actual = "минус ноль рублей и девяносто копеек";
        String expected = numberConverter.convertingNumberToString(testNumber7);
        assertEquals(expected, actual);
    }
}
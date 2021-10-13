package ru.otus.numberInWords.logic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberConverterParameterizedTest {

    private NumberConverter numberConverter = new NumberConverter();

    @ParameterizedTest(name = "{index}: number = {1}")
    @MethodSource("methodData")
    void convertingNumberToStringTest(String expected, double param) {
        assertEquals(expected, numberConverter.convertingNumberToString(new InputNumber(param)));
    }

    static Stream<Arguments> methodData(){
        return Stream.of(
                arguments("пятьдесят шесть триллионов сто двадцать три миллиарда девятьсот пятьдесят четыре миллиона " +
                        "триста пятьдесят три тысячи четыреста пятьдесят один рубль" +
                        " и девятнадцать копеек",
                        56_123_954_353_451.19),
                arguments("минус шестьсот семьдесят восемь миллиардов девятьсот пятьдесят четыре миллиона " +
                        "триста пятьдесят три тысячи четыреста двенадцать рублей и десять копеек",
                        -678_954_353_412.1),
                arguments("триста пятьдесят три тысячи четыреста пятьдесят два рубля и одна копейка",
                        353_452.01),
                arguments("минус четыреста пятьдесят шесть рублей и две копейки",
                        -456.02),
                arguments("девяносто шесть тысяч четыреста пятьдесят шесть рублей ",
                        96_456),
                arguments("минус девятьсот восемьдесят один триллион двести тридцать два миллиарда триста сорок шесть миллионов" +
                                " пятьсот двенадцать тысяч двести тридцать четыре рубля ",
                        -981_232_346_512_234L),
                arguments("минус ноль рублей и девяносто копеек",
                        -0.9),
                arguments("ноль рублей ",
                        0)
        );
    }
}
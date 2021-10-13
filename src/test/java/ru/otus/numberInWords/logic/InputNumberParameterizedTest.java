package ru.otus.numberInWords.logic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class InputNumberParameterizedTest {

    @ParameterizedTest(name = "{index}: value={0} - number={1}")
    @MethodSource("pennyIndexTestData")
    void getPennyIndexTest(int expected, double param) {
        assertEquals(expected, new InputNumber(param).getPennyIndex());
    }

    @ParameterizedTest(name = "{index}: value={0} - number={1}")
    @MethodSource("fractionalPartOfNumberTestData")
    void getFractionalPartOfNumberTest(long expected, double param) {
        assertEquals(expected, new InputNumber(param).getFractionalPartOfNumber());
    }

    @ParameterizedTest(name = "{index}: value={0} - number={1}")
    @MethodSource("numberLengthTestData")
    void getNumberLengthTest(int expected, double param) {
        assertEquals(expected, new InputNumber(param).getNumberLength());
    }

    @ParameterizedTest(name = "{index}: value={0} - number={1}")
    @MethodSource("fractionalPartLengthTestData")
    void getFractionalPartLengthTest(int expected, double param) {
        assertEquals(expected, new InputNumber(param).getFractionalPartLength());
    }

    @ParameterizedTest(name = "{index}: value={0} - number={1}")
    @MethodSource("wholePartOfNumberTestData")
    void getWholePartOfNumberTest(long expected, double param) {
        assertEquals(expected, new InputNumber(param).getWholePartOfNumber());
    }

    @ParameterizedTest(name = "{index}: value={0} - number={1}")
    @MethodSource("currencyIndexTestData")
    void getCurrencyIndexTest(int expected, double param) {
        assertEquals(expected, new InputNumber(param).getCurrencyIndex());
    }

    @ParameterizedTest(name = "{index}: value={0} - number={1}")
    @MethodSource("isPositiveNumberData")
    void isPositiveNumber(boolean expected, double param) {
        assertEquals(expected, new InputNumber(param).isPositiveNumber());
    }

    static Stream<Arguments> pennyIndexTestData(){
        return Stream.of(
                arguments(2, 56_123_954_353_451.19),
                arguments(2, -678_954_353_412.1),
                arguments(0, 353_452.01),
                arguments(1, -456.02)
        );
    }

    static Stream<Arguments> fractionalPartOfNumberTestData(){
        return Stream.of(
                arguments(19, 56_123_954_353_451.19),
                arguments(10, -678_954_353_412.1),
                arguments(1, 353_452.01),
                arguments(2, -456.02),
                arguments(0, 96_456)
        );
    }

    static Stream<Arguments> numberLengthTestData(){
        return Stream.of(
                arguments(14, 56_123_954_353_451.19),
                arguments(15, 156_123_954_353_451.19),
                arguments(12, -678_954_353_412.1),
                arguments(6, 353_452.01),
                arguments(3, -456.02),
                arguments(5, 96_456)
        );
    }

    static Stream<Arguments> fractionalPartLengthTestData(){
        return Stream.of(
                arguments(2, 56_123_954_353_451.19),
                arguments(1, -678_954_353_412.1)
        );
    }

    static Stream<Arguments> wholePartOfNumberTestData(){
        return Stream.of(
                arguments(56_123_954_353_451L, 56_123_954_353_451.19),
                arguments(156_123_954_353_451L, 156_123_954_353_451.19),
                arguments(678_954_353_412L, -678_954_353_412.1),
                arguments(353_452, 353_452.01),
                arguments(456, -456.02),
                arguments(96456, 96_456),
                arguments(0, 0.12)
        );
    }

    static Stream<Arguments> currencyIndexTestData(){
        return Stream.of(
                arguments(0, 56_123_954_353_451.19),
                arguments(2, -678_954_353_412.1),
                arguments(1, 353_452.01)
        );
    }

    static Stream<Arguments> isPositiveNumberData(){
        return Stream.of(
                arguments(true, 56_123_954_353_451.19),
                arguments(false, -678_954_353_412.1)
        );
    }
}
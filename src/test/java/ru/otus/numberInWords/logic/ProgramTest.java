package ru.otus.numberInWords.logic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ProgramTest {

    @ParameterizedTest(name = "{index}) input: {1}")
    @MethodSource("programData")
    void startProgramTest(String expected, String param) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(param.getBytes());
        System.setIn(byteArrayInputStream);

        new Program().start();
        String actual = byteArrayOutputStream.toString().trim();

        assertEquals(expected, actual);

    }

     static Stream<Arguments> programData(){
        return Stream.of(
                arguments("пятьдесят шесть триллионов сто двадцать три миллиарда девятьсот пятьдесят четыре миллиона " +
                                "триста пятьдесят три тысячи четыреста пятьдесят один рубль" +
                                " и девятнадцать копеек",
                        "56123954353451,19"),
                arguments("минус шестьсот семьдесят восемь миллиардов девятьсот пятьдесят четыре миллиона " +
                                "триста пятьдесят три тысячи четыреста двенадцать рублей и десять копеек",
                        "-678954353412,1"),
                arguments("триста пятьдесят три тысячи четыреста пятьдесят два рубля и одна копейка",
                        "353452,01"),
                arguments("минус четыреста пятьдесят шесть рублей и две копейки",
                        "-456,02"),
                arguments("девяносто шесть тысяч четыреста пятьдесят шесть рублей",
                        "96456"),
                arguments("минус девятьсот восемьдесят один триллион двести тридцать два миллиарда триста сорок шесть миллионов" +
                                " пятьсот двенадцать тысяч двести тридцать четыре рубля",
                        "-981232346512234"),
                arguments("минус ноль рублей и девяносто копеек",
                        "-0,9"),
                arguments("ноль рублей",
                        "0"),
                arguments("Введенные данные не корректны, попробуйте еще раз",
                        "asd"),
                arguments("Введенные данные не корректны, попробуйте еще раз",
                        "20f")
        );
     }

}
package ru.otus.numberInWords.data;

import lombok.Getter;

/**
 * Хранит строковое представление простых чисел, их разрядов и окончания
 */

@Getter
public enum Number {

    RANKS(new String[]{"", "тысяч", "миллион", "миллиард", "триллион"}),
    RANKS_ENDINGS(new String[][]{{"на ", "е ", ""},     //тысача в ед. числе
                                {"а ", "и ", " "},      //тысача во множ. числе
                                {" ", "а ", "ов "}}),   //миллион и выше
    PRIME_NUMBERS_DOZENS_AND_HUNDREDS(new String[][]{{"", "од", "дв", "три ", "четыре ", "пять ", "шесть ", "семь ", "восемь ", "девять "},
            {"", "десять ", "двадцать ", "тридцать ", "сорок ", "пятьдесят ", "шестьдесят ", "семьдесят ", "восемьдесят ", "девяносто "},
            {"", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ", "семьсот ", "восемьсот ", "девятьсот "}}),
    PRIME_FROM_11_TO_19(new String[]{"", "одиннадцать ", "двенадцать ", "тринадцать ",
            "четырнадцать ", "пятнадцать ", "шестнадцать ", "семнадцать ", "восемнадцать ", "девятнадцать "}),
    EXCEPTIONAL_CASE("ноль ");

    private String[] valuesArray;
    private String[][] twoDimensionalValuesArray;
    private String exceptionalCase;

    Number(String[] numbers) {
        this.valuesArray = numbers;
    }

    Number(String[][] strings) {
        this.twoDimensionalValuesArray = strings;
    }

    Number(String exceptionalCase) {
        this.exceptionalCase = exceptionalCase;
    }
}

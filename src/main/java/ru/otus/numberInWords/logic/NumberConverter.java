package ru.otus.numberInWords.logic;

import ru.otus.numberInWords.data.Currency;
import ru.otus.numberInWords.data.Messages;
import ru.otus.numberInWords.data.Number;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс обрабатывает полученное число и приводит его к строке
 */
public class NumberConverter {

    /**
     * Индекс разряда числа
     */
    private int dischargeRank;
    /**
     * Индекс окончания числа в зависимости от разряда
     */
    private int numbersRanksEndingsIndex;
    /**
     * Константы для задания размера StringBuilder
     */
    private static final int MAIN_STRING_BUILDER_SIZE = 100;
    private static final int ADDITIONAL_STRING_BUILDER_SIZE = 50;

    /**
     * Конвертирует число в строку (финальный метод, собирает в одну строку результаты преобразований остальных методов)
     *
     * @param inputNumber - класс хранящий полученное число
     * @return - строку с результатом преобразования
     */
    public String convertNumberToString(InputNumber inputNumber) {
        if (!isInputNumberInAcceptableRange(inputNumber))
            return Messages.INPUT_FAIL.getMessage();

        StringBuilder numberToString = formStringBuilderOfCurrencyPart(inputNumber);

        if (inputNumber.getFractionalPartLength() > 0) {
            numberToString.append(Messages.AND.getMessage());
            numberToString.append(formStringBuilderOfPennyPart(inputNumber));
        }
        if (!inputNumber.isPositiveNumber()) {
            numberToString.insert(0, Messages.MINUS.getMessage());
        }
        numberToString.trimToSize();
        return numberToString.toString();
    }

    /**
     * Формирует строковое представление целой части числа (рубли)
     *
     * @param inputNumber - класс хранящий полученное число
     * @return - StringBuilder с результатом
     */
    private StringBuilder formStringBuilderOfCurrencyPart(InputNumber inputNumber) {
        StringBuilder stringRepresentationOfNumber = new StringBuilder(MAIN_STRING_BUILDER_SIZE);
        long number = inputNumber.getWholePartOfNumber();

        if (number == 0) {
            stringRepresentationOfNumber.append(Number.EXCEPTIONAL_CASE.getExceptionalCase());
        } else {
            convertNumberToString(number, stringRepresentationOfNumber, Currency.CURRENCY);
        }
        stringRepresentationOfNumber.append(Currency.CURRENCY.getCurrencyValuesArray()[inputNumber.getCurrencyIndex()]);

        return stringRepresentationOfNumber;
    }

    /**
     * Формирует строковое представление дробной части числа (копейки)
     *
     * @param inputNumber - класс хранящий полученное число
     * @return - StringBuilder с результатом
     */
    private StringBuilder formStringBuilderOfPennyPart(InputNumber inputNumber) {
        long fractionalPartOfNumber = inputNumber.getFractionalPartOfNumber();
        StringBuilder pennyToString = new StringBuilder(ADDITIONAL_STRING_BUILDER_SIZE);
        convertNumberToString(fractionalPartOfNumber, pennyToString, Currency.PENNY);
        pennyToString.append(Currency.PENNY.getCurrencyValuesArray()[inputNumber.getPennyIndex()]);

        return pennyToString;
    }

    /**
     * Определяет допустимую длину числа для преобразования
     */
    private boolean isInputNumberInAcceptableRange(InputNumber inputNumber) {
        return inputNumber.getNumberLength() <= 15 && inputNumber.getFractionalPartLength() <= 2;
    }

    /**
     * Конвертирует число в строку (добавляет окончания, считает индекс разрядов числа)
     *
     * @param number                       - число которое необходимо конвертировать в строку
     * @param stringRepresentationOfNumber - StringBuilder для сохранения результата преобразования
     * @param currency                     - валюта с которой нужно выполнять конвертацию
     */
    private void convertNumberToString(long number, StringBuilder stringRepresentationOfNumber, Currency currency) {
        while (number > 0) {
            int partOfTheNumber = (int) (number % 1000);
            String result = convertPartNumberToString(partOfTheNumber, currency);

            if (dischargeRank > 0)
                stringRepresentationOfNumber.insert(0,
                        result + Number.RANKS_ENDINGS.getTwoDimensionalValuesArray()[Math.min(dischargeRank, 2)][numbersRanksEndingsIndex]);
            else
                stringRepresentationOfNumber.insert(0, result);

            number /= 1000;
            dischargeRank++;
        }
        dischargeRank = 0;
    }

    /**
     * Определяет с помощью какого из методов конвертировать часть числа (до 3-х цифр) в строку
     *
     * @param number   - число которое необходимо конвертировать в строку
     * @param currency - валюта с которой нужно выполнять конвертацию
     * @return - результат в виде строки
     */
    private String convertPartNumberToString(int number, Currency currency) {
        StringBuilder stringBuffer = new StringBuilder(ADDITIONAL_STRING_BUILDER_SIZE);
        stringBuffer.append(Number.RANKS.getValuesArray()[dischargeRank]);
        List<Integer> listOfNumbers = convertNumberToList(number);
        int extraNumber = number % 100;
        if (extraNumber > 10 && extraNumber < 20) {
            convertPartNumberToStringWithExtraNumber(listOfNumbers, stringBuffer);
        } else {
            convertPartNumberToStringWithStandardNumber(currency, listOfNumbers, stringBuffer);
        }
        return stringBuffer.toString();
    }

    /**
     * Совершает преобразование для "исключительного" случая (число кончается на цифры от 11 до 19)
     *
     * @param listOfNumbers - List цифр (не более 3-х)
     * @param stringBuffer  - буфер для записи результата
     */
    private void convertPartNumberToStringWithExtraNumber(List<Integer> listOfNumbers, StringBuilder stringBuffer) {
        int index = listOfNumbers.get(0);
        stringBuffer.insert(0, Number.PRIME_FROM_11_TO_19.getValuesArray()[index]);
        if (listOfNumbers.size() > 2) {
            int hundred = listOfNumbers.get(2);
            stringBuffer.insert(0, Number.PRIME_NUMBERS_DOZENS_AND_HUNDREDS.getTwoDimensionalValuesArray()[2][hundred]);
        }
        numbersRanksEndingsIndex = 2;
    }

    /**
     * Преобразует поочередно каждую цифру из листа в строку с учетом окончаний для переданной валюты
     *
     * @param currency     - валюта, исходя из которой формируются окончания слов
     * @param listONumbers - List с цифрами (не более 3-х)
     * @param stringBuffer - буфер для сохранения результата
     */
    private void convertPartNumberToStringWithStandardNumber(Currency currency, List<Integer> listONumbers, StringBuilder stringBuffer) {
        for (int i = 0; i < listONumbers.size(); i++) {
            int index = listONumbers.get(i);
            if (i == 0) {
                switch (index) {
                    case 1:
                        stringBuffer.insert(0, Number.PRIME_NUMBERS_DOZENS_AND_HUNDREDS.getTwoDimensionalValuesArray()[i][index]);
                        stringBuffer.insert(2, dischargeRank == 1 ? Number.RANKS_ENDINGS.getTwoDimensionalValuesArray()[i][0] : currency.getPrimeNumbersEndings()[0]);
                        numbersRanksEndingsIndex = 0;
                        break;
                    case 2:
                        stringBuffer.insert(0, Number.PRIME_NUMBERS_DOZENS_AND_HUNDREDS.getTwoDimensionalValuesArray()[i][index]);
                        stringBuffer.insert(2, dischargeRank == 1 ? Number.RANKS_ENDINGS.getTwoDimensionalValuesArray()[i][1] : currency.getPrimeNumbersEndings()[1]);
                        numbersRanksEndingsIndex = 1;
                        break;
                    case 3:
                    case 4:
                        stringBuffer.insert(0, Number.PRIME_NUMBERS_DOZENS_AND_HUNDREDS.getTwoDimensionalValuesArray()[i][index]);
                        numbersRanksEndingsIndex = 1;
                        break;
                    default:
                        stringBuffer.insert(0, Number.PRIME_NUMBERS_DOZENS_AND_HUNDREDS.getTwoDimensionalValuesArray()[i][index]);
                        numbersRanksEndingsIndex = 2;
                }
            } else {
                stringBuffer.insert(0, Number.PRIME_NUMBERS_DOZENS_AND_HUNDREDS.getTwoDimensionalValuesArray()[i][index]);
            }
        }
    }

    /**
     * Преобразует число в List состоящий из его цифр
     *
     * @param number - число для преобразования
     * @return - List из числа
     */
    private List<Integer> convertNumberToList(int number) {
        List<Integer> listOfNumbers = new ArrayList<>(3);
        while (number != 0) {
            listOfNumbers.add(number % 10);
            number /= 10;
        }
        return listOfNumbers;
    }
}

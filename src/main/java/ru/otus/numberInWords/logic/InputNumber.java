package ru.otus.numberInWords.logic;

import lombok.Getter;
import ru.otus.numberInWords.data.Currency;

import java.math.BigDecimal;


/**
 * Класс для хранения полученного числа и его частичной обработки
 */
public class InputNumber {
    @Getter
    private final long wholePartOfNumber;
    @Getter
    private final int currencyIndex;
    @Getter
    private final boolean isPositiveNumber;
    @Getter
    private final double fractionalPartMarker;
    private final BigDecimal fractionalPart;
    private long fractionalPartOfNumber;
    private int pennyIndex;

    public InputNumber(double inputNumber) {
        BigDecimal wholeNumber = BigDecimal.valueOf(Math.abs(inputNumber));
        isPositiveNumber = isPositive(inputNumber);
        wholePartOfNumber = (long) Math.abs(inputNumber);
        fractionalPart = wholeNumber.subtract(BigDecimal.valueOf(wholePartOfNumber));
        currencyIndex = calculateCurrencyIndex(wholePartOfNumber);
        fractionalPartMarker = fractionalPart.doubleValue();
    }


    /**
     * @return индекс с нужным склонением копеек
     * {@link Currency#PENNY}
     */
    public int getPennyIndex(){
        convertFractionalPartOfNumber();
        calculatePennyIndex();
        return pennyIndex;
    }

    private boolean isPositive(double number){
        if(number == 0)
            return true;
        return number > 0;
    }

    private void calculatePennyIndex(){
        pennyIndex = calculateCurrencyIndex(fractionalPartOfNumber);
    }

    /**
     * @return дробную часть числа (long)
     */
    public long getFractionalPartOfNumber() {
        convertFractionalPartOfNumber();
        return fractionalPartOfNumber;
    }

    private void convertFractionalPartOfNumber(){
        fractionalPartOfNumber = (long) (getFractionalPartMarker() * 100);
    }

    /**
     * @return длину целой части числа
     */
     public int getNumberLength(){
        String temp = String.valueOf(wholePartOfNumber);
        return temp.length();
    }

    /**
     * @return длину дробной части числа
     */
    public int getFractionalPartLength(){
        if(fractionalPartMarker > 0) {
            String[] number = String.valueOf(fractionalPart).split("\\.");
            return number[1].length();
        } else {
            return 0;
        }
    }

    private int calculateCurrencyIndex(long number){
        int decimalPlaceOfNumber = (int) (number % 100);
        if(decimalPlaceOfNumber > 10 && decimalPlaceOfNumber < 20) {
            return 2;
        }
        int lastDigitOfNumber = (int) (number % 10);
        switch (lastDigitOfNumber){
            case 1:
                return 0;
            case 2:
            case 3:
            case 4:
                return 1;
            default:
                return 2;
        }
    }

}

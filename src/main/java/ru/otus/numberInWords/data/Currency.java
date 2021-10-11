package ru.otus.numberInWords.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Хранит валюту и окончания простых чисел перед ней (1 и 2)
 */

@AllArgsConstructor
@Getter
public enum Currency {
    CURRENCY(new String[]{"рубль ", "рубля ", "рублей "},
            new String[]{"ин ", "а "}),
    PENNY(new String[]{"копейка", "копейки", "копеек"},
            new String[]{"на ", "е "});

    private final String[] currencyValuesArray;
    private final String[] primeNumbersEndings;
}

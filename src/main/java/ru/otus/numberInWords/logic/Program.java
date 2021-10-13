package ru.otus.numberInWords.logic;

import ru.otus.numberInWords.data.Messages;

import java.util.Scanner;

/**
 * Класс запускает преобразование числа в строку
 */
public class Program {

    InputNumber inputNumber;
    NumberConverter numberConverter = new NumberConverter();
    Scanner input = new Scanner(System.in);

    /**
     * @return булево значение - продолжать ли дальше выполнение или был инициализирован выход
     */
    public boolean start(){
        if (input.hasNextDouble()) {
            double number = input.nextDouble();
            inputNumber = new InputNumber(number);
            String result = numberConverter.convertNumberToString(inputNumber);
            System.out.println(result);
        } else if (input.nextLine().equalsIgnoreCase("Q")) {
            return false;
        } else {
            System.out.println(Messages.FAIL_MESSAGE.getMessage());
        }
        return true;
    }
}

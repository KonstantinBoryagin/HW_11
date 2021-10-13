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

    public void startProgram() {
        System.out.printf(Messages.WELCOME_MESSAGE.getMessage());

        while (true) {
//            String s = input.nextLine();
//            s.replace('.',',');
//            double x = Double.valueOf(s);
            if(!start()){
                break;
            }
//            if (input.hasNextDouble()) {
//                double number = input.nextDouble();
//                inputNumber = new InputNumber(number);
//                String result = numberConverter.convertingNumberToString(inputNumber);
//                System.out.println(result);
//            } else if (input.nextLine().equalsIgnoreCase("Q")) {
//                break;
//            } else {
//                System.out.println(Messages.FAIL_MESSAGE.getMessage());
//            }
        }
    }

    public boolean start(){
        if (input.hasNextDouble()) {
            double number = input.nextDouble();
            inputNumber = new InputNumber(number);
            String result = numberConverter.convertingNumberToString(inputNumber);
            System.out.println(result);
        } else if (input.nextLine().equalsIgnoreCase("Q")) {
            return false;
        } else {
            System.out.println(Messages.FAIL_MESSAGE.getMessage());
        }
        return true;
    }
}

package ru.otus.numberInWords.data;

import lombok.Getter;

/**
 * Хранит сообщения для пользователя
 */

@Getter
public enum Messages {
    INPUT_FAIL("Введенное число выходит за допустимый диапазон"),
    WELCOME_MESSAGE ( "Число прописью!" +
            "\nВведите число в формате 'рубли' или 'рубли','копейки' " +
            "\nДля завершения введите 'Q'\n"),
    FAIL_MESSAGE ("Введенные данные не корректны, попробуйте еще раз");

    private final String message;

    Messages(String message) {
        this.message = message;
    }
}

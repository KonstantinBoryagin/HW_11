package ru.otus.numberInWords;

import ru.otus.numberInWords.data.Messages;
import ru.otus.numberInWords.logic.Program;


/**
 * @author Konstantin Boryagin
 */
public class Main {

    public static void main(String[] args) {
        Program program = new Program();

        System.out.printf(Messages.WELCOME_MESSAGE.getMessage());

        boolean programStatus = true;

        while(programStatus){
            programStatus = program.start();

        }
    }
}

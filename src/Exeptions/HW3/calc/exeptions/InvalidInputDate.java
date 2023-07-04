package Exeptions.HW3.calc.exeptions;

import java.io.IOException;

/**
 * Обязательное проверяемое исключение на проверку вводивых данных
 */
public class InvalidInputDate extends IOException {
    public InvalidInputDate(String message) {
        super(message);
    }
}

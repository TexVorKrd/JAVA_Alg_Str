package Exeptions.HW3.calc.exeptions;

import java.io.IOException;

/**
 * Обязательное проверяемое исключение на неверный выбор пункта меню
 */
public class NotValidChose extends IOException {
    public NotValidChose(String message) {
        super(message);
    }
}

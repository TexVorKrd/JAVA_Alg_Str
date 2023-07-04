package Exeptions.HW3.calc.exeptions;

/**
 * Исключение для проверки валидности данных
 */
public class IncorrectDataInput extends RuntimeException{
    public IncorrectDataInput(String message) {
        super(message);
    }

    public IncorrectDataInput(String message, Throwable cause) {
        super(message, cause);
    }
}

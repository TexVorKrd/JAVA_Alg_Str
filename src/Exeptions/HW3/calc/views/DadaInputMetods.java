package Exeptions.HW3.calc.views;

import Exeptions.HW3.calc.exeptions.InvalidInputDate;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DadaInputMetods {

    /**
     * Запрос целого числа
     *
     * @param msg    - Приглашение к запросу
     * @param errMsg - Сообщение об ощибке отображаемое перед приглашением если оно не равно ""
     * @return
     * @throws InvalidInputDate
     */
    public static int askInt(String msg, String errMsg) throws InvalidInputDate {
        if (!errMsg.equals("")) {
            System.out.println("-------");
            System.out.println(errMsg);
        }
        System.out.println("-------");
        System.out.println(msg);

        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException exception) {
            throw new InvalidInputDate("Требуется ввести целое число");
        }
    }

}

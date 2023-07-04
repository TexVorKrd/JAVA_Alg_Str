package Exeptions.HW3.calc.controler;

import Exeptions.HW3.calc.exeptions.IncorrectDataInput;
import Exeptions.HW3.calc.exeptions.InvalidInputDate;
import Exeptions.HW3.calc.exeptions.NotValidChose;
import Exeptions.HW3.calc.views.DadaInputMetods;
import Exeptions.HW3.calc.views.Menu;

import java.util.HashMap;
import java.util.Scanner;

public class Lancher {
    private Menu menu;
    private final HashMap<Integer, Runnable> menuExecuter;
    String errorMsg = "";
    private final String FINALMSG = "ВЫПОЛНЕНИЕ ЗАВЕРШЕНО";
    private final String ACTIONMSG = "\n\nВЫПОЛНЯЕТСЯ ОПЕРАЦИЯ - ";
    private final String SPLITER = "----------";
    private final String CONTMSG = "ДЛЯ ПРОДОЛЖЕНИЯ ВВЕДИТЕ ЧТО УГОДНО";


    /**
     * Ланчер
     */
    public Lancher() {
        this.menu = new Menu();
        this.menuExecuter = new HashMap<>();

        try {
            menuCreater();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }

    }

    /**
     * Запуск ланчера
     */
    public void start() {
        boolean exit = false;
        Integer menuSelection;

        while (!exit) {
            menu.show();

            try {
                menuSelection = DadaInputMetods.askInt("ВЫБЕРИТЕ ПУНКТ МЕНЮ", errorMsg);
                menu.isPresent(menuSelection);
                errorMsg = "";
                if (menu.exit(menuSelection)) exit = true;

                if (!exit) {
                    menuExec(menuSelection);
                }

            } catch (InvalidInputDate | NotValidChose | IncorrectDataInput exception) {
                errorMsg = exception.getMessage();
            }
        }
        finish();
    }

    /**
     * Действие по завершению ланчера
     */
    public void finish() {
        System.out.println(FINALMSG);
    }


    /**
     * Обработка выбраного пункта меню
     *
     * @param selection - результат выбора
     * @throws IncorrectDataInput - проброс исключения
     */
    private void menuExec(int selection) throws IncorrectDataInput {

        System.out.print(ACTIONMSG);
        System.out.println(menu.getMenu(selection));

        menuExecuter.get(selection).run();

        System.out.println(SPLITER);
        System.out.println(CONTMSG);

        new Scanner(System.in).nextLine();
    }

    /**
     * Формирование меню
     *
     * @throws Exception
     */
    private void menuCreater() throws Exception {
        try {
            if (menu.add(1, "СЛОЖЕНИЕ ЦЕЛЫХ ЧИСЕЛ")) menuExecuter.put(1, MenuAction.add);
            if (menu.add(2, "РАЗНОСТЬ ЦЕЛЫХ ЧИСЕЛ")) menuExecuter.put(2, MenuAction.dif);
            if (menu.add(3, "УМНОЖЕНИЕ ЦЕЛЫХ ЧИСЕЛ")) menuExecuter.put(3, MenuAction.multi);
            if (menu.add(4, "ДЕЛЕНИЕ ЦЕЛЫХ ЧИСЕЛ")) menuExecuter.put(4, MenuAction.div);
            if (menu.add(5, "ВОЗВЕДЕНИЕ В СТЕПЕНЬ  ЦЕЛЫХ ЧИСЕЛ")) menuExecuter.put(5, MenuAction.calculatePower);
        } catch (Exception exception) {
            throw new Exception("Не удалось создать меню", exception);
        }
    }
}

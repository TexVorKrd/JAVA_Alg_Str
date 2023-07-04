package Exeptions.HW3.calc.views;

import Exeptions.HW3.calc.exeptions.NotValidChose;

import java.util.Arrays;
import java.util.HashMap;

public class Menu {

    private final HashMap<Integer, String> menu;
    Integer exit;

    public Menu() {
        this.menu = new HashMap<>();
        exit = 0;
        menu.put(0, "ВЫХОД");
    }

    /**
     * Вывод меню
     */
    public void show() {
        System.out.println("\n".repeat(20));
        Integer[] menuSelector = menu.keySet().toArray(Integer[]::new);
        Arrays.sort(menuSelector);
        for (Integer n : menuSelector) {
            System.out.println(n + " - " + menu.get(n));
        }
    }

    /**
     * Проверка на наличие пункта меню
     *
     * @param chose - проверяемый элемент
     * @return
     */
    public void isPresent(Integer chose) throws NotValidChose {
        if (!menu.containsKey(chose)) throw new NotValidChose("Нет такого пункта меню, выберите из возможных");
    }

    /**
     * Проверка на выбор пункта меню соответствующего выходу
     *
     * @param element - проверяемый элемент
     * @return
     */
    public boolean exit(Integer element) {
        if (element.equals(exit)) return true;
        return false;
    }

    /**
     * Добавление элемента меню
     *
     * @param key   - Пункт меню
     * @param value - Наименование пункта
     * @return
     */
    public boolean add(int key, String value) {
        if (value == null || key < 1 || menu.containsKey(key)) return false;
        menu.put(key, value);
        return true;
    }


    public String getMenu(int element) {
        return menu.get(element);
    }
}

package Exeptions.HW3.calc.controler;

import Exeptions.HW3.calc.exeptions.IncorrectDataInput;
import Exeptions.HW3.calc.exeptions.InvalidInputDate;
import Exeptions.HW3.calc.services.PowerCalculator;
import Exeptions.HW3.calc.views.DadaInputMetods;

/**
 * Набор функциональных интерфейсов для привязки к пунктам меню
 * Для ввода данных и отображения результата
 */
public class MenuAction {
    private static PowerCalculator calc = new PowerCalculator();

    public static final Runnable add= ()-> {
            try {
                int a = DadaInputMetods.askInt("Введите первое слагаемое", "");
                int b = DadaInputMetods.askInt("Введите второе слагаемое", "");
                System.out.println("Результат сложения  "+a+" + "+b+" = "+calc.sum(a,b));
            } catch (InvalidInputDate exeption){
                throw new IncorrectDataInput("Для сложения данные введены неверно\n"+exeption.getMessage(),exeption);
            }
        };

    public static  Runnable dif =() -> {
        try {
            int a = DadaInputMetods.askInt("Введите уменьшаемое", "");
            int b = DadaInputMetods.askInt("Введите вычитаемое", "");
            System.out.println("Разность  "+a+" - "+b+" = "+calc.dif(a,b));
        } catch (InvalidInputDate exeption){
            throw new IncorrectDataInput("Для вычитания данные введены неверно\n"+exeption.getMessage(),exeption);
        }
    };

    public static  Runnable div =() -> {
        try {
            int a = DadaInputMetods.askInt("Введите делимое", "");
            int b = DadaInputMetods.askInt("Введите делитель", "");
            System.out.println("Отношение  "+a+" / "+b+" = "+calc.div(a,b));
        } catch (InvalidInputDate |IncorrectDataInput exeption){
            throw new IncorrectDataInput("Для деления данные введены неверно\n"+exeption.getMessage(),exeption);
        }
    };

    public static  Runnable  multi=() -> {
        try {
            int a = DadaInputMetods.askInt("Введите первый множетель", "");
            int b = DadaInputMetods.askInt("Введите второй множетель", "");
            System.out.println("Разность  "+a+" * "+b+" = "+calc.multi(a,b));
        } catch (InvalidInputDate exeption){
            throw new IncorrectDataInput("Для умножения данные введены неверно\n"+exeption.getMessage(),exeption);
        }
    };

    public static  Runnable calculatePower =() -> {
        try {
            int a = DadaInputMetods.askInt("Введите число возводимое в степень", "");
            int b = DadaInputMetods.askInt("Введите степень", "");
            System.out.println("Разность  "+a+"^"+b+" = "+calc.calculatePower(a,b));
        } catch (InvalidInputDate |IncorrectDataInput exeption){
            throw new IncorrectDataInput("Для возведения в степень данные введены неверно\n"+exeption.getMessage(),exeption);
        }
    };

}

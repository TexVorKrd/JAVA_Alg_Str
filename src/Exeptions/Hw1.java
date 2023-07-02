package Exeptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Hw1 {
    public static void main(String[] args) {

        ex1();
        ex2();
    }

    public static void ex1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Деление двух чисел");

        try {
            System.out.print("Введите первое число - ");
            int a1 = scanner.nextInt();
            System.out.print("Введите второе число - ");
            int a2 = scanner.nextInt();
            if (a2 == 0) throw new ArithmeticException("Делить на ноль нельзя");
            System.out.println(a1 / a2);
        } catch (InputMismatchException exception) {
            System.out.println("нужно ввести целое число");
        } catch (ArithmeticException exception) {
            System.out.println("Не пытайтесь делить на ноль");
        }
    }



    public static void ex2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите возраст");
        String msg = scanner.nextLine();

        try {
            int age = Integer.parseInt(msg);
            System.out.println(age);
        } catch (NumberFormatException exception) {
            System.out.println("Введите целое число");
        }
    }

}

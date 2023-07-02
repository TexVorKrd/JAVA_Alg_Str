package Exeptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Hw2 {
    public static void main(String[] args) throws myExeption {

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
            if (a2 == 0) throw new myDivZerro("Делить на ноль нельзя");
            System.out.println(a1 / a2);
        } catch (InputMismatchException exception) {
            System.out.println("нужно ввести целое число");
        }
    }

    public static void ex2() throws myExeption {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Положительное число - ");
            int a1 = scanner.nextInt();


            if (a1 <= 0) throw new myExeption("Число должно быть положительным");
            System.out.println("Введино число" + a1);

        } catch (InputMismatchException exception) {
            System.out.println("нужно ввести целое число");
        }
    }


    public static class myDivZerro extends ArithmeticException {
        public myDivZerro() {
        }

        public myDivZerro(String s) {
            super(s);
        }
    }

    public static class myExeption extends Exception {

        public myExeption() {
        }

        public myExeption(String message) {
            super(message);
        }
    }

}

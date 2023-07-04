package Exeptions.HW3.calc.services;

import Exeptions.HW3.calc.exeptions.IncorrectDataInput;

public class PowerCalculator implements CalcMetods {

    @Override
    public int sum(int a1, int a2) {
        return a1 + a2;
    }

    @Override
    public int dif(int a1, int a2) {
        return a1 - a2;
    }

    @Override
    public double div(int a1, int a2) {
        if (a2 != 0) return (double) a1 / (double) a2;
        throw new IncorrectDataInput("Делитель не может быть равен 0");
    }

    @Override
    public long multi(int a1, int a2) {
        return a1 * a2;
    }

    @Override
    public int calculatePower(int a1, int a2) {
        if (a1 == 0) throw new IncorrectDataInput("При возведение в степень основание не может быть равно 0");
        if (a2 < 0) throw new IncorrectDataInput("Степень должна быть положительной");
        if (a2 == 0) return 1;
        return (int) Math.pow(a1, a2);
    }
}

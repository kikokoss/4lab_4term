package space.realkarmakun.tasks.first;


import space.realkarmakun.tasks.Task;

import java.util.Scanner;

import static space.realkarmakun.io.Input.readDoubleWithCheck;

public class Formula extends Task {
    public double x;
    public double y;
    public double z;
    public double result;

    @Override
    public void execute(Scanner inp) {

        System.out.println("Введите x:");
        setX(readDoubleWithCheck(inp ,"x не является double, попробуйте еще раз."));

        while (true) {
            try {
                System.out.println("Введите y:");
                setY(readDoubleWithCheck(inp,"y не является double, попробуйте еще раз."));
                break;
            } catch (FormulaException e) {
                // Продолжаем попытки получения верного числа
            }
        }

        while (true) {
            try {
                System.out.println("Введите z:");
                setZ(readDoubleWithCheck(inp,"z не является double, попробуйте еще раз."));
                break;
            } catch (FormulaException e) {
                // Продолжаем попытки получения верного числа
            }
        }

        calculateResult();
        System.out.printf("(%.3f + %.3f^(1/2)) / %.3f 1= %.3f \n", x, y, z, result);

    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) throws FormulaException {
        if (y < 0 ) {
            throw new FormulaException("Значение y не может быть меньше нуля. (Корень отрицательного числа).");
        } else {
            this.y = y;
        }
    }

    public void setZ( double z) throws FormulaException {
        if (z == 0) {
            throw new FormulaException("Значение z не может быть равно нулю. (Деление на ноль).");
        } else {
            this.z = z;
        }
    }

    public void calculateResult() {
        this.result = ((x + Math.sqrt(y)) / z);
    }


}

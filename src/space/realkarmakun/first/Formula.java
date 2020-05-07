package space.realkarmakun.first;


import java.util.Scanner;

import static space.realkarmakun.io.Input.readDoubleWithCheck;

public class Formula {
    public double x;
    public double y;
    public double z;
    public double result;

    //Конструктор по факту считает все что надо и выдает ответ. Если x, y или z не подходят, он будет переспрашивать
    public Formula(Scanner inp) {

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

        this.result = calculateResult(x,y,z);
        System.out.printf("(%.3f + %.3f^(1/2)) / %.3f 1= %.3f \n", x, y, z, result);

    }


    private void setX(double x) {
        this.x = x;
    }

    private void setY(double y) throws FormulaException {
        if (y < 0 ) {
            System.out.println("Значение y не может быть меньше нуля. (Корень отрицательного числа).");
            throw new FormulaException();
        } else {
            this.y = y;
        }
    }

    public void setZ( double z) throws FormulaException {
        if (z == 0) {
            System.out.println("Значение z не может быть равно нулю. (Деление на ноль).");
            throw new FormulaException();
        } else {
            this.z = z;
        }
    }

    private static double calculateResult(double x, double y, double z) {
        y = Math.sqrt(y);
        return ((x + y) / z);
    }


}

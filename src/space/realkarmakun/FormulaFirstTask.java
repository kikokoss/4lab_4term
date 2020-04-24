package space.realkarmakun;


import java.util.Scanner;

import static space.realkarmakun.Utils.readDoubleWithCheck;

public class FormulaFirstTask {
    public double x;
    public double y;
    public double z;
    public double result;

    //Конструктор по факту считает все что надо и выдает ответ. Если x, y или z не подходят, он будет ругаться
    public FormulaFirstTask(Scanner inp) {

        // Почему то выкидывает обратно в меню вместо того чтобы вернутся к tryAgainLabel
        tryAgainLabel: try {
            System.out.println("Введите x:");
            setX(readDoubleWithCheck(inp ,"x не является double, попробуйте еще раз."));
            System.out.println("Введите y:");
            setY(readDoubleWithCheck(inp,"y не является double, попробуйте еще раз."));
            System.out.println("Введите z:");
            setZ(readDoubleWithCheck(inp,"z не является double, попробуйте еще раз."));
            result = calculateResult(x,y,z);
            System.out.printf("(%.3f + %.3f^(1/2)) / %.3f 1= %.3f \n", x, y, z, result);
        } catch (FormulaFirstTaskException e) {
            break tryAgainLabel;
        }

    }


    private void setX(double x) {
        this.x = x;
    }

    private void setY(double y) throws FormulaFirstTaskException {
        if (y < 0 ) {
            System.out.println("Значение y не может быть меньше нуля. (Корень отрицательного числа).");
            throw new FormulaFirstTaskException();
        } else {
            this.y = y;
        }
    }

    public void setZ( double z) throws FormulaFirstTaskException {
        if (z == 0) {
            System.out.println("Значение z не может быть равно нулю. (Деление на ноль).");
            throw new FormulaFirstTaskException();
        } else {
            this.z = z;
        }
    }

    private static double calculateResult(double x, double y, double z) {
        y = Math.sqrt(y);
        return ((x + y) / z);
    }


}

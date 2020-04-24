package space.realkarmakun;

import java.util.Scanner;

import static space.realkarmakun.Utils.readIntWithCheck;

public class Menu {

    private static Scanner inp = new Scanner(System.in);

    public Menu() {
        System.out.println("=============================================");
        System.out.println("Константинов Павел. Лабараторная работа. 4 Семестр.");
        System.out.println("v.1.1");
        System.out.println("0. Выход из программы.");
        System.out.println("1. 'Hello, World!'");
        System.out.println("2. Formula Calculation");
        System.out.println("=============================================");

        //Выбор пункта меню через switch
        boolean exit = false;
        do {
            System.out.print("Введите номер пункта меню: ");
            int key = readIntWithCheck(inp,"Не верный ввод. Должно быть число");
            switch (key) {
                case (0):
                    System.exit(0);
                    break;
                case (1):
                    new HelloWorld();
                    exit = true;
                    break;
                case (2):
                    System.out.println("Будет вычислятся следующая формула: (x + y^(1/2)) / z");
                    new FormulaFirstTask(inp);
                    exit = true;
                    break;
                default:
                    System.out.println("Введенное значение не соответствует ни одному из меню.");
                    System.out.print("Попробуйте еще раз: ");
                    break;
            }
        } while (!exit);
    }




}


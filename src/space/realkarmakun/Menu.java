package space.realkarmakun;

import space.realkarmakun.tasks.first.Formula;
import space.realkarmakun.tasks.first.HelloWorld;
import space.realkarmakun.tasks.second.Recursion;
import space.realkarmakun.tasks.third.StringJob;

import java.util.Scanner;

import static space.realkarmakun.io.Input.readIntWithCheck;

public class Menu {

    private static Scanner inp = new Scanner(System.in);
    public Menu() {
        System.out.println("=============================================");
        System.out.println("Константинов Павел. Лабараторная работа. 4 Семестр.");
        System.out.println("v.1.2");
        System.out.println("[0] Выход из программы.");
        System.out.println("[1] 'Hello, World!'");
        System.out.println("[2] Formula Calculation");
        System.out.println("[3] Accurate power of two");
        System.out.println("[4] String Job");
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
                    new HelloWorld().execute(inp);
                    exit = true;
                    break;
                case (2):
                    System.out.println("Будет вычислятся следующая формула: (x + y^(1/2)) / z");
                    new Formula(inp);
                    exit = true;
                    break;
                case (3):
                    System.out.println("Даты должны быть в формате ДД.ММ.ГГГГ");
                    new Recursion(inp);
                    exit = true;
                    break;
                case (4):
                    new StringJob(inp);
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


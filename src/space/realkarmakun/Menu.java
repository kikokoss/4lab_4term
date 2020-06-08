package space.realkarmakun;

import space.realkarmakun.menu.*;
import space.realkarmakun.tasks.first.Formula;
import space.realkarmakun.tasks.first.HelloWorld;
import space.realkarmakun.tasks.second.Recursion;
import space.realkarmakun.tasks.third.StringJob;

import java.util.ArrayList;
import java.util.Scanner;

import static space.realkarmakun.io.Input.readIntWithCheck;

public class Menu {

    public static ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
    private static Scanner inp = new Scanner(System.in);

    public Menu() {
        getMenuItems();
        printMenuItems();
        menuChooser(inp);
    }


    private static void getMenuItems() {

        if (menuItems.size() == 0) {
            menuItems.add(new MenuItemExit());
            menuItems.add(new MenuItemHelloWorld());
            menuItems.add(new MenuItemFormula());
            menuItems.add(new MenuItemRecursion());
            menuItems.add(new MenuItemStringJob());
        }
    }

    public static void printMenuItems() {

        System.out.println("=============================================");
        System.out.println("Константинов Павел. Лабараторная работа. 4 Семестр.");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("[%d] %s\n", i, menuItems.get(i).getTitle());
        }
        System.out.println("=============================================");
    }

    public static void menuChooser(Scanner inp) {

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

                    new Formula().execute(inp);
                    exit = true;
                    break;
                case (3):
                    System.out.println("Даты должны быть в формате ДД.ММ.ГГГГ");
                    new Recursion().execute(inp);
                    exit = true;
                    break;
                case (4):
                    new StringJob().execute(inp);
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


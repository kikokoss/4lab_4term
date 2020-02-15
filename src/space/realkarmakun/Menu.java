package space.realkarmakun;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static Scanner inp = new Scanner(System.in);
    private static int key;
    // private static MenuOptions key;

    public static void evoke() {
        System.out.println("=============================================");
        System.out.println("Константинов Павел. Лабараторная работа. 4 Семестр.");
        System.out.println("v.1");
        System.out.println("0. Выход из программы.");
        System.out.println("1. Работа с формулой (1 задание).");
        /*
        for (MenuOptions o : MenuOptions.values()) {
            System.out.println(o.getOrderNumber() + ". " + o.getDescription());
        }
         */
        System.out.println("=============================================");
        System.out.print("Введите ваше число: ");

        boolean foolCheck = false;
        do {
            try {
                key = inp.nextInt();
                inp.nextLine();
                foolCheck = true;
            } catch (InputMismatchException ex) {
                System.out.println("Неверный ввод. Попробуйте еще раз.");
                System.out.println("int: На вводе должно быть число.");
                inp.nextLine();
            }
        } while (!foolCheck);

        boolean exit = false;
        do {
            switch (key) {
                case (0):
                    System.exit(0);
                    break;
                case (1):
                    formulaSequence();
                    exit = true;
                    break;
                default:
                    System.out.println("Введенное значение не соответствует ни одному из меню.");
                    System.out.print("Попробуйте еще раз: ");
                    key = inp.nextInt();
                    inp.nextLine();
                    break;
            }
        } while (!exit);
    }

    public static void formulaSequence() {

        double x = 0;
        double y = 0;
        double z = 0;

        System.out.println("Должна быть выполнена следущая формула: (x + y^(1/2)) / z");
        System.out.println("x, y, z должны быть double.");

        boolean foolCheck = false;
        do {
            try {
                System.out.print("Введите x: ");
                x = inp.nextDouble();
                System.out.print("Введите y: ");
                y = inp.nextDouble();
                System.out.print("Введите z: ");
                z = inp.nextDouble();
                foolCheck = true;
            } catch (InputMismatchException ex) {
                System.out.println("Неверный ввод. Попробуйте еще раз.");
                System.out.println("double: На вводе должно быть число.");
                inp.nextLine();
            }
        } while (!foolCheck);

        System.out.print("("+ x + " + " + y + Utils.calculation(x,y,z));


    }

    }
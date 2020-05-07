package space.realkarmakun.io;

import java.util.InputMismatchException;
import java.util.Scanner;

// Просто класс с разными побочными методами

public class Input {

    //Метод проверки на дурака для int. Пропускает только int.
    public static int readIntWithCheck(Scanner inp, String errorMessage) {
        int result;
        while (true) {
            try {
                result = inp.nextInt();
                inp.nextLine();
                break;
            } catch ( InputMismatchException ex) {
                System.out.println(errorMessage);
                inp.nextLine();
            }
        }
        return result;
    }

    //Метод проверки на дурака для double. Пропускает только double.
    public static double readDoubleWithCheck(Scanner inp, String errorMessage) {
        double result;
        while (true) {
            try {
                result = inp.nextDouble();
                inp.nextLine();
                break;
            } catch (InputMismatchException ex) {
                System.out.println(errorMessage);
                inp.nextLine();
            }
        }
        return result;
    }

}

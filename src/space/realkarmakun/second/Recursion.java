package space.realkarmakun.second;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Scanner;

import static space.realkarmakun.io.Input.readDateWithCheck;


public class Recursion {

    public Recursion(Scanner inp) {

        while (true) {
            System.out.println("Введите первую дату: ");
            Calendar firstDate = readDateWithCheck(inp);
            System.out.println("Введите вторую дату: ");
            Calendar secondDate = readDateWithCheck(inp);

            long n = calculateDaysBetween(firstDate, secondDate);
            if (!(n >= 100)) {
                accuratePowerOfTwo(n);
                break;
            } else {
                System.out.println("n больше либо равно 100, попробуйте взять меньший отрезок. \n");
            }
        }

    }

    private long calculateDaysBetween(Calendar firstDate, Calendar secondDate) {
        return ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant());
    }

    private void accuratePowerOfTwo(long n) {
        if (n == 1) {
            System.out.println("YES");
        } else if ( n % 2 == 0) {
            accuratePowerOfTwo(n / 2);
        } else {
            System.out.println("NO");
        }
    }

}

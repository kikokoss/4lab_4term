package space.realkarmakun.tasks.second;

import space.realkarmakun.tasks.Task;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import static space.realkarmakun.io.Input.readDateWithCheck;


public class Recursion extends Task {

    public ArrayList<Calendar> firstSegment = new ArrayList<Calendar>();
    public ArrayList<Calendar> secondSegment = new ArrayList<Calendar>();

    public Recursion(Scanner inp) {

        while (true) {

            this.firstSegment.clear();
            this.secondSegment.clear();

            System.out.println("[!!!] Сейчас на ввод будет приниматся ПЕРВЫЙ отрезок.");
            createSegment(firstSegment, inp);
            System.out.println("[!!!] Сейчас на ввод будет приниматся ВТОРОЙ отрезок.");
            createSegment(secondSegment, inp);

            ArrayList<Calendar> nSegment = calculateSegmentsForN(firstSegment,secondSegment);

            if (nSegment == null) {
                break;
            }


            long n = calculateDaysBetween(nSegment.get(0), nSegment.get(1));
            if (!(n >= 10)) {
                accuratePowerOfTwo(n);
                break;
            } else {
                System.out.println("n больше либо равно 10, попробуйте взять меньший отрезок. \n");
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

    private void createSegment(ArrayList<Calendar> segment, Scanner inp) {

        segment.clear();
        while (true) {
            System.out.println("Введите первую дату отрезка:");
            Calendar firstDate = readDateWithCheck(inp);
            System.out.println("Введите вторую дату отрезка:");
            Calendar secondDate = readDateWithCheck(inp);
            if (secondDate.compareTo(firstDate) <= 0) {
                System.out.println("Вторая дата меньше первой или ей равна. Проверьте ввод.");
            } else {
                segment.add(firstDate);
                segment.add(secondDate);
                break;
            }
        }

    }

    private ArrayList<Calendar> calculateSegmentsForN(ArrayList<Calendar> firstSegment, ArrayList<Calendar> secondSegment) {
        /*
        if (firstSegment.get(1).compareTo(secondSegment.get(0)) <= 0) {
            System.out.println("Ваши отрезки не пересекаются. N будет меньше либо равен нулю. Попробуйте еще раз");
            return null;
        } else {
            ArrayList<Calendar> result = new ArrayList<Calendar>();
            result.add(secondSegment.get(0));
            result.add(firstSegment.get(1));
            return result;
        }
         */
        ArrayList<Calendar> result = new ArrayList<Calendar>();

        if (firstSegment.get(1).compareTo(secondSegment.get(0)) <= 0) {
            System.out.println("Ваши отрезки не пересекаются. N будет меньше либо равен нулю. Попробуйте еще раз");
            return null;
        }

        result.add(calendarMax(firstSegment.get(0), secondSegment.get(0)));
        result.add(calendarMin(firstSegment.get(1), secondSegment.get(1)));
        return result;
    }

    private Calendar calendarMax(Calendar first, Calendar second) {
        if (first.compareTo(second) > 0) {
            return first;
        } else if (first.compareTo(second) < 0) {
            return second;
        } else {
            return second;
        }
    }

    private Calendar calendarMin(Calendar first, Calendar second) {
        if (first.compareTo(second) < 0) {
            return first;
        } else if (first.compareTo(second) > 0) {
            return second;
        } else {
            return first;
        }
    }

}

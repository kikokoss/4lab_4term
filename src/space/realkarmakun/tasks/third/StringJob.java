package space.realkarmakun.tasks.third;

import space.realkarmakun.tasks.Task;

import java.util.Scanner;

import static space.realkarmakun.io.Input.readStringWithCheck;

public class StringJob extends Task {

    @Override
    public void execute(Scanner inp) {

        System.out.println("Введите первую строку:");
        String firstString = readStringWithCheck(inp, "Вы ввели не строку. Попробуйте еще раз.");
        System.out.println("Введите вторую строку:");
        String secondString = readStringWithCheck(inp, "Вы ввели не строку. Попробуйте еще раз.");

        try {
            testEquality(firstString, secondString);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            testTrueEquality(firstString, secondString);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            testReverse(firstString, secondString);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkStringForRegex(firstString, "Первая строка являеется...");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkStringForRegex(secondString, "Вторая строка является");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testEquality(String first, String second) throws ValidationException {
        if (stringsEquality(first, second)) {
            System.out.println("Строки совпадают посимвольно!");
        } else {
            throw new ValidationException("Строки НЕ совпадают посимвольно!\n");
        }
    }

    public void testTrueEquality(String first, String second) throws ValidationException {
        if (stringsTrueEquality(first, second)) {
            System.out.println("Строки совпадают посимвольно без пробелов и в нижнем регистре!");
        } else {
            throw new ValidationException("Строки НЕ совпадают посимвольно без пробелов в нижнем регистре!");
        }
    }

    public void testReverse(String first, String second) throws ValidationException {
        if (first.equals(reverseString(second))) {
            System.out.println("Строки являются полиморфными!");
        } else {
            throw new ValidationException("Строки не полиморфны!");
        }
    }

    public boolean stringsEquality(String first, String second) {

        return first.compareTo(second) == 0;
    }

    public boolean stringsTrueEquality(String first, String second) {

        first = first.toLowerCase();
        second = second.toLowerCase();

        first = first.replaceAll("\\s","");
        second = second.replaceAll("\\s","");

        return first.compareTo(second) == 0;
    }

    public String reverseString(String input) {

        String result = "";

        for (int i = input.length() -1; i >= 0; i--) {
            result = result + input.charAt(i);
        }

        return result;

    }

    public void checkStringForRegex(String input, String addition) throws ValidationException {

        int check = 0;

        System.out.println(addition);

        String emailRegex = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+";
        if (input.matches(emailRegex)) {
            System.out.println("Электронной почтой");
            check = check +1;
        }

        String phoneRegex = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";
        if (input.matches(phoneRegex)) {
            System.out.println("Номером телефона");
            check = check +1;
        }

        String ipv4Regex = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}";
        if (input.matches(ipv4Regex)) {
            System.out.println("IPv4 адресом");
            check = check +1;
        }

        if (check == 0) {
            throw new ValidationException("Не почтой, не телефоном и не IPv4 адресом");
        }
    }


}

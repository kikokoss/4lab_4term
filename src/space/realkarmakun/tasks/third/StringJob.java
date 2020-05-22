package space.realkarmakun.tasks.third;

import space.realkarmakun.tasks.Task;

import java.util.Scanner;

import static space.realkarmakun.io.Input.readStringWithCheck;

public class StringJob extends Task {

    public StringJob(Scanner inp) {

        System.out.println("Введите первую строку:");
        String firstString = readStringWithCheck(inp, "Вы ввели не строку. Попробуйте еще раз.");
        System.out.println("Введите вторую строку:");
        String secondString = readStringWithCheck(inp, "Вы ввели не строку. Попробуйте еще раз.");

        if (stringsEquality(firstString,secondString)) {
            System.out.println("Строки совпадают посимвольно!");
        }

        if (stringsTrueEquality(firstString, secondString)) {
            System.out.println("Строки совпадают посимвольно без пробелов и в нижнем регистре!");
        }

        if (firstString.equals(reverseString(secondString))) {
            System.out.println("Первая строка равна перевернутой второй.");
        }

        checkStringForRegex(firstString, "Первая строка является...");
        checkStringForRegex(secondString, "Вторая строка является...");
    }


    private boolean stringsEquality(String first, String second) {

        return first.compareTo(second) == 0;
    }

    private boolean stringsTrueEquality(String first, String second) {

        first = first.toLowerCase();
        second = second.toLowerCase();

        first = first.replaceAll("\\s","");
        second = second.replaceAll("\\s","");

        return first.compareTo(second) == 0;
    }

    private String reverseString(String input) {

        String result = "";

        for (int i = input.length() -1; i >= 0; i--) {
            result = result + input.charAt(i);
        }

        return result;

    }

    private void checkStringForRegex(String input, String addition) {

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
            System.out.println("Не почтой, не телефоном и не IPv4 адресом");
        }
    }


}

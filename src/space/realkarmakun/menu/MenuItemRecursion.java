package space.realkarmakun.menu;

import space.realkarmakun.tasks.second.Recursion;

import java.util.Scanner;

import static space.realkarmakun.io.Output.printOutLn;

public class MenuItemRecursion extends MenuItem {

    public MenuItemRecursion() {
        this.title = "Accurate power of two";
    }


    @Override
    public void initialize(Scanner inp) {
        printOutLn("Даты должны быть в формате ДД.ММ.ГГГГ");
        new Recursion().execute(inp);
    }
}

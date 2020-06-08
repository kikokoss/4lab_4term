package space.realkarmakun.menu;

import space.realkarmakun.tasks.first.HelloWorld;

import java.util.Scanner;

public class MenuItemExit extends MenuItem {

    public MenuItemExit() {
        this.title = "Exit the program";
    }

    @Override
    public void initialize(Scanner inp) {
        System.exit(0);
    }
}

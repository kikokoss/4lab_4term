package space.realkarmakun.menu;

import space.realkarmakun.tasks.first.HelloWorld;

import java.util.Scanner;

public class MenuItemHelloWorld extends MenuItem {

    public MenuItemHelloWorld() {
        this.title = "'Hello, world!'";
    }


    @Override
    public void initialize(Scanner inp) {
        new HelloWorld().execute(inp);
    }
}

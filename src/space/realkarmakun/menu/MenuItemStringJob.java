package space.realkarmakun.menu;

import space.realkarmakun.tasks.third.StringJob;

import java.util.Scanner;

public class MenuItemStringJob extends MenuItem {

    public MenuItemStringJob() {
        this.title = "String Job";
    }

    @Override
    public void initialize(Scanner inp) {
        new StringJob().execute(inp);
    }
}

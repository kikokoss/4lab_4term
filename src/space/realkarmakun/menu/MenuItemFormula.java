package space.realkarmakun.menu;

import space.realkarmakun.tasks.first.Formula;

import java.util.Scanner;

public class MenuItemFormula extends MenuItem {

    public MenuItemFormula() {
        this.title = "Formula calculation";
    }

    @Override
    public void initialize(Scanner inp) {
        System.out.println("Будет вычислятся следующая формула: (x + y^(1/2)) / z");
        new Formula().execute(inp);
    }
}

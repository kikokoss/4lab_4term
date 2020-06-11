package space.realkarmakun.menu;

import space.realkarmakun.tasks.first.Formula;

import java.util.Scanner;

import static space.realkarmakun.io.Output.printOutLn;

public class MenuItemFormula extends MenuItem {

    public MenuItemFormula() {
        this.title = "Formula calculation";
    }

    @Override
    public void initialize(Scanner inp) {
        printOutLn("Будет вычислятся следующая формула: (x + y^(1/2)) / z");
        new Formula().execute(inp);
    }
}

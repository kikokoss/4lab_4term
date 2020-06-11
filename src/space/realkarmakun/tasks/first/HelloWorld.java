package space.realkarmakun.tasks.first;

import space.realkarmakun.tasks.Task;

import java.util.Scanner;

import static space.realkarmakun.io.Output.printOutLn;

public class HelloWorld extends Task {

    public String taskName = "Hello World";

    @Override
    public void execute(Scanner inp) {
        printOutLn("Hello, World!");
    }

}

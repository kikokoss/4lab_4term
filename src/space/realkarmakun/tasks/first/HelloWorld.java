package space.realkarmakun.tasks.first;

import space.realkarmakun.tasks.Task;

import java.util.Scanner;

public class HelloWorld extends Task {

    public String taskName = "Hello World";

    @Override
    public void execute(Scanner inp) {
        System.out.println("Hello, World!");
    }

}

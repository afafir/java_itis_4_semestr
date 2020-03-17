package containerTask;

import containerTask.interpreter.Interpreter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static ApplicationContext context = new AnnotationConfigApplicationContext("containerTask");

    public static void main(String[] args) {
        Interpreter interpreter = context.getBean(Interpreter.class);
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).split(" ")[0].equals("stop")) {
            interpreter.interpret(line);
        }

    }
}

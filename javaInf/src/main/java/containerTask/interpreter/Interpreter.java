package containerTask.interpreter;

import containerTask.Main;
import containerTask.container.Container;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Interpreter {

    public Container container;


    public void interpret(String line) {
        String[] payload = line.split(" ");
        String command = payload[0];
        switch (command) {
            case "add":
                container.add(payload[1]);
                break;
            case "out":
                container.out().forEach(System.out::println);
                break;
            case "config":
                ApplicationContext context = new AnnotationConfigApplicationContext("containerTask");
                if (payload[1].equals("file")) {
                    container = (Container) Main.context.getBean("file");
                } else container = (Container) Main.context.getBean("memory");
        }
    }

}

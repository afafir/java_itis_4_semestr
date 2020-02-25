import interpreter.InterpreterClient;
import interpreter.InterpreterClientImpl;
import model.TaskContainer;

public class Main {
    public static void main(String[] args) {
        InterpreterClient client = new InterpreterClientImpl();
        client.handle("add task with some text");
        client.handle("copy 0");
        client.handle("up 0");
        client.handle("up 0 1");
        String text = TaskContainer.get(0).getText();
        System.out.println(text);

    }




}

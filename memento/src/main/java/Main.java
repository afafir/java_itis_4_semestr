import browser.Browser;
import command.Interpreter;

public class Main {
    public static void main(String[] args) {
        Browser browser = new Browser();
        System.out.println(1);
        Interpreter interpreter = new Interpreter(browser);
        interpreter.link("page1");
        interpreter.back();
        interpreter.forward();
        System.out.println(1);


    }
}

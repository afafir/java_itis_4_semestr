package interpreter;

import model.Task;

public interface InterpreterClient<T> {
    void handle(String params);
    void upState(String... params);
    void downState(String... params);
    void createTask(String text);
    void copy(Task task);
}

package interpreter;

import model.Task;
import model.TaskImpl;
import model.TaskContainer;
import model.TaskLogger;
import prototype.TaskPrototype;
import state.DraftState;

public class InterpreterClientImpl implements InterpreterClient {


    public void handle(String execution) {
        String command = execution.substring(0, execution.indexOf(" "));
        String params[] = execution.substring(execution.indexOf(" ")+1).split(" ");
        switch (command) {
            case "up":
                upState(params);
                break;
            case "down":
                downState(params);
                break;
            case "add":
                String text = execution.substring(execution.indexOf(" "));
                if (!text.equals("")){
                    createTask(text);
                }
                else System.out.println("Введите текст");
                break;
            case "copy":
                if (TaskContainer.get(Integer.valueOf(params[0]))!=null){
                copy(TaskContainer.get(Integer.valueOf(params[0])));}
                else System.out.println("TaskImpl doesn't exist");
                break;
            default:
                System.out.println("Undefined command");
        }


    }

    //up id param
    @Override
    public void upState(String... params) {
        Integer id = Integer.parseInt(params[0]);
        if (params.length == 2) {
            Integer value = Integer.parseInt(params[1]);
            TaskContainer.get(id).up(value);
        } else
            TaskContainer.get(id).up();
    }

    @Override
    public void downState(String... params) {
        Integer id = Integer.parseInt(params[0]);
        if (params[1] != null) {
            String value = params[1];
            TaskContainer.get(id).down(value);
        } else
            TaskContainer.get(id).down();
    }

    @Override
    public void createTask(String text) {
        TaskImpl task = TaskImpl.getBuilder().setId()
                .setText(text)
                .build();
        task.setState(new DraftState(task));
        TaskContainer.put(new TaskLogger(task));
    }

    @Override
    public void copy(Task task) {
        TaskPrototype.Clone(task);
    }
}

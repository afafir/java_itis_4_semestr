package prototype;

import model.Task;
import model.TaskImpl;
import model.TaskContainer;

public class TaskPrototype {

    public static void Clone (Task task){
        TaskImpl cloned = TaskImpl.getBuilder()
                        .setId()
                        .setState(task.getState())
                        .setText(task.getText())
                        .setState(task.getState())
                        .setDeveloperId(task.getDeveloperId())
                        .setTesterId(task.getTesterId()).build();
        TaskContainer.put(cloned);
        System.out.println(task.getId()+ " cloned");
    }

}

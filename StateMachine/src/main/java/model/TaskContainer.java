package model;

import java.util.HashMap;
import java.util.Map;

public class TaskContainer {
    private static Map<Integer, Task> integerTaskMap = new HashMap<>();

    public static Task get(Integer id){
        return integerTaskMap.get(id);
    }

    public static void put (Task task){
        integerTaskMap.put(task.getId(), task);
    }


}

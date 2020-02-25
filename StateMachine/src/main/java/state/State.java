package state;

import model.TaskImpl;

public abstract class State{
    TaskImpl task;

    State(TaskImpl task){
        this.task = task;
    }

    public abstract void up();
    public abstract void down();
    public abstract void up(int id);
    public abstract void down(String error);

}

package state;

import model.TaskImpl;

public class ResolvedState extends State {
    ResolvedState(TaskImpl task) {
        super(task);
    }

    @Override
    public void up() {
        System.out.println("Set testerId");


    }

    @Override
    public void down() {
        task.setState(new InProgressState(task));

    }

    @Override
    public void up(int id) {
        task.setTesterId(id);
        task.setState(new TestState(task));

    }

    @Override
    public void down(String error) {
        down();

    }
}

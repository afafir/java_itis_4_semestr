package state;

import model.TaskImpl;

public class InProgressState extends State{
    InProgressState(TaskImpl task) {
        super(task);
    }

    @Override
    public void up() {
        task.setState(new ResolvedState(task));
    }

    @Override
    public void down() {
        task.setState(new AssignState(task));

    }

    @Override
    public void up(int id) {
        up();
    }

    @Override
    public void down(String error) {
        down();
    }
}

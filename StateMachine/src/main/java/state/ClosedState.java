package state;

import model.TaskImpl;

public class ClosedState extends State {
    ClosedState(TaskImpl task) {
        super(task);
    }

    @Override
    public void up() {

    }

    @Override
    public void down() {

    }

    @Override
    public void up(int id) {

    }

    @Override
    public void down(String error) {

    }
}

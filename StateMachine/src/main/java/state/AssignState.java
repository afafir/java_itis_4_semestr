package state;

import model.TaskImpl;

public class AssignState extends State {
    AssignState(TaskImpl task) {
        super(task);
    }

    @Override
    public void up() {
        task.setState(new InProgressState(task));

    }

    @Override
    public void down() {
        this.task.setDeveloperId(-1);
        task.setState(new OpenState(task));
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

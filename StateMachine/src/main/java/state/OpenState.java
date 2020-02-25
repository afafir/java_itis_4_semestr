package state;

import model.TaskImpl;

public class OpenState extends State {
    OpenState(TaskImpl task) {
        super(task);
    }

    @Override
    public void up() {
        System.out.println("Set developer id");

    }

    @Override
    public void down() {
        this.task.setId(-1);
        task.setState(new BackLogState(task));
    }

    @Override
    public void up(int developerId) {
        this.task.setId(developerId);
        task.setState(new AssignState(task));
    }

    @Override
    public void down(String error) {
        down();
    }
}

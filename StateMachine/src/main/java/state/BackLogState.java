package state;

import model.TaskImpl;

public class BackLogState extends State {
    BackLogState(TaskImpl task) {
        super(task);
    }

    @Override
    public void up() {
        task.setState(new OpenState(task));
    }

    @Override
    public void down() {
        System.out.println("Операция невозможна");

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

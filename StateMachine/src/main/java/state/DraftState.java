package state;

import model.TaskImpl;

public class DraftState extends State{

    public DraftState(TaskImpl task) {
        super(task);
    }

    @Override
    public void up() {
        task.setState(new OpenState(task) );
    }

    @Override
    public void down() {


    }

    @Override
    public void up(int id) {
        up();
    }

    @Override
    public void down(String error) {
    }
}

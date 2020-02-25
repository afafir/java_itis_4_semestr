package model;

import state.State;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class TaskLogger implements Task {

    private TaskImpl task;
    private String filename;

    public TaskLogger(TaskImpl task) {
        filename = task.getId() + "_log";
        File file = new File(filename);
        this.task = task;
    }

    @Override
    public void up() {
        task.up();
        log("TaskImpl " + task.getId() + " in" + task.getState().getClass().getName());

    }

    @Override
    public void up(Integer value) {
        task.up(value);
        log("TaskImpl " + task.getId() + " in" + task.getState().getClass().getName());
    }

    @Override
    public void down() {
        task.down();
        log("TaskImpl " + task.getId() + " in" + task.getState().getClass().getName());

    }

    @Override
    public void down(String value) {
        task.down(value);
        log("TaskImpl " + task.getId() + " in" + task.getState().getClass().getName());

    }

    @Override
    public State getState() {
        log("TaskImpl " + task.getId() + " in" + task.getState().getClass().getName());
        return task.getState();
    }

    @Override
    public void setState(State state) {
        log("TaskImpl state set into " + state.getClass().getName());
        this.task.setState(state);
    }

    @Override
    public Integer getId() {
        log("TaskImpl have " + task.getId());

        return task.getId();
    }

    @Override
    public void setId(Integer id) {
        log("TaskImpl " + task.getId() + " in" + task.getState().getClass().getName());
        this.task.setId(id);
    }

    @Override
    public Integer getDeveloperId() {
        log("TaskImpl developerId is " + ((task.getDeveloperId() == null) ? "null" : task.getDeveloperId()));
        return this.task.getDeveloperId();
    }

    @Override
    public void setDeveloperId(Integer developerId) {
        log("TaskImpl developerId set to " + developerId);
        this.task.setDeveloperId(developerId);
    }

    @Override
    public Integer getTesterId() {
        log("TaskImpl testerId" + ((task.getTesterId() == null) ? "null" : task.getTesterId()));
        return this.task.getTesterId();
    }

    @Override
    public void setTesterId(Integer testerId) {
        this.task.setTesterId(testerId);
        log("TaskImpl testerId set to " + testerId);
    }

    @Override
    public String getText() {
        log("TaskImpl text is  " + task.getText());

        return task.getText();
    }

    @Override
    public void setText(String text) {
        log("TaskImpl text set to " + text);
        task.setText(text);
    }

    @Override
    public String getError() {
        log("TaskImpl error is" + ((task.getError() == null) ? "null" : task.getError()));
        return task.getError();
    }

    @Override
    public void setError(String error) {
        task.setError(error);
        log("TaskImpl error set to is" + task.getError());

    }

    public void log(String toWrite) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(toWrite+ " - " + LocalDateTime.now());
        } catch (IOException e) {
            throw new IllegalStateException();
        }

    }
}







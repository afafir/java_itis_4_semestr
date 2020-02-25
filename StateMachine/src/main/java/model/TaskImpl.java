package model;

import state.DraftState;
import state.State;

public class TaskImpl implements Task {
    private static int count = 0;
    private State state;
    private Integer id;
    private Integer developerId;
    private Integer testerId;
    private String text;
    private String error;

    private TaskImpl() {
    }

    public TaskImpl(String text) {
        this.id = count++;
        this.text = text;
        this.state = new DraftState(this);
    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public Integer getTesterId() {
        return testerId;
    }

    public void setTesterId(Integer testerId) {
        this.testerId = testerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void up(Integer value) {
        state.up(value);
    }

    public void up() {
        state.up();
    }

    public void down(String value) {
        state.down();
    }

    public void down() {
        state.down();
    }


    public static Builder getBuilder() {
        return new TaskImpl().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setState(State state) {
            TaskImpl.this.state = state;
            return this;
        }

        public Builder setId() {
            TaskImpl.this.id = count++;
            return this;
        }

        public Builder setText(String text) {
            TaskImpl.this.text = text;
            return this;
        }

        public Builder setDeveloperId(Integer taskId) {
            TaskImpl.this.developerId = taskId;
            return this;
        }

        public Builder setTesterId(Integer testerId){
            TaskImpl.this.testerId = testerId;
            return this;

        }

        public TaskImpl build() {
            return TaskImpl.this;
        }

    }


}





































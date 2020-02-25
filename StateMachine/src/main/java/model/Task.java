package model;

import state.State;

public interface Task {
    void up();
    void up(Integer value);
    void down();
    void down(String value);
    State getState();
    void setState(State state);
    Integer getId();
    void setId(Integer id);
    Integer getDeveloperId();
    void setDeveloperId(Integer developerId);
    Integer getTesterId();
    void setTesterId(Integer testerId);
    String getText();
    void setText(String text);
    String getError();
    void setError(String error);

}

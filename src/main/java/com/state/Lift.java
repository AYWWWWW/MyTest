package com.state;

/**
 * Created by anyanwen on 2016/11/7 15:51.
 */
public class Lift {

    public Lift(State state) {
        this.state = state;
    }

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void start() {
        state.start(this);
    }

    public void open() {
        state.open(this);
    }

    public void stop() {
        state.stop(this);
    }

    public void close() {
        state.close(this);
    }
}

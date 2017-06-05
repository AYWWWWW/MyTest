package com.state;

/**
 * Created by anyanwen on 2016/11/7 15:45.
 */
public interface State {

    void stop(Lift lift);

    void start(Lift lift);

    void open(Lift lift);

    void close(Lift lift);
}

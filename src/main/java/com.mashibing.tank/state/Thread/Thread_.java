package com.mashibing.tank.state.Thread;

/**
 * @date 2020/6/12 - 10:45
 */
public abstract class Thread_ {
    ThreadState_ state;

    void move(Action input){state.move(input);};
    void run(){state.run();};
}

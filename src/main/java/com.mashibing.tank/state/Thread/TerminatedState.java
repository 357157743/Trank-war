package com.mashibing.tank.state.Thread;

/**
 * @date 2020/6/12 - 10:58
 */
public class TerminatedState extends ThreadState_ {
    private Thread_ t;

    public TerminatedState(Thread_ t) { this.t= t; }

    @Override
    void move(Action input) {

    }

    @Override
    void run() {

    }
}

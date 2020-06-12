package com.mashibing.tank.state.Thread;

/**
 * @date 2020/6/12 - 10:53
 */
public class RunningState extends ThreadState_ {

    private Thread_ t;

    public RunningState(Thread_ t) { this.t = t; }

    @Override
    void move(Action input) {
        if(input.msg == "start"){
            t.state = new TerminatedState(t);
        }
    }

    @Override
    void run() {

    }
}

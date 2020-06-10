package com.mashibing.tank.Command;

/**
 * @date 2020/6/10 - 17:01
 */
public class DeleteCommand extends Command {
    Context c;
    String deleted;

    public DeleteCommand(Context c) {
        this.c = c;
    }
    @Override
    public void doit() {
       deleted =c.msg.substring(0,5);
       c.msg = c.msg.substring(5,c.msg.length());
    }

    @Override
    public void undo() {
        c.msg = deleted + c.msg;
    }
}

package com.mashibing.tank.Command;

/** 命令行模式
 * @date 2020/6/10 - 17:01
 */
public class CopyCommand extends Command  {
    Context c;

    public CopyCommand(Context c) {
        this.c = c;
    }
    @Override
    public void doit() {
        c.msg = c.msg +c.msg;
    }

    @Override
    public void undo() {
        c.msg = c.msg.substring(0,c.msg.length()/2);
    }
}

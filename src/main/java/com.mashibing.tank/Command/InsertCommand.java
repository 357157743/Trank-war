package com.mashibing.tank.Command;

/**
 * @date 2020/6/10 - 17:01
 */
public class InsertCommand extends Command {
    Context c;
    String strToInsert = "http://www.mashibing.com";

    public InsertCommand(Context c) {
        this.c = c;
    }
    @Override
    public void doit() {
        c.msg=c.msg + strToInsert;
    }

    @Override
    public void undo() {
        c.msg=c.msg.substring(0,c.msg.length()-strToInsert.length());
    }
}

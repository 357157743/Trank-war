package com.mashibing.tank.Command;

/**
 * @date 2020/6/10 - 17:01
 */
public class Main {
    public static void main(String[] args) {
        Context c= new Context();

        Command insertCommand = new InsertCommand(c);
        insertCommand.doit();
        insertCommand.undo();

        Command copyCommand = new CopyCommand(c);
        copyCommand.doit();
        copyCommand.undo();

        Command deleteCommand = new DeleteCommand(c);
        deleteCommand.doit();
        deleteCommand.undo();

        System.out.println(c.msg);
    }
}

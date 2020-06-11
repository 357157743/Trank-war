package com.mashibing.tank.Command;

import java.util.ArrayList;
import java.util.List;

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

        List<Command> commandList = new ArrayList<>();
        commandList.add(new InsertCommand(c));
        commandList.add(new CopyCommand(c));
        commandList.add(new DeleteCommand(c));

        for (Command comn: commandList) {
            comn.doit();
        }

        System.out.println(c.msg);

        // 倒叙
        for (int i = commandList.size()-1; i >=0 ; i--) {
            commandList.get(i).undo();
        }

        System.out.println(c.msg);
    }
}

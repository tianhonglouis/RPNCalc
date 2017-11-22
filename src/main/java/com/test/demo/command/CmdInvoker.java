package com.test.demo.command;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CmdInvoker {

    private Command cmd;

    private Stack<Command> undoList = new Stack<Command>();

    public void setCommand(Command cmd){
        this.cmd = cmd;
    }

    public void execute() throws Exception {
        undoList.push(cmd);
        cmd.execute();
    }

    public void undo() throws Exception {
        if(!undoList.isEmpty()){
            Command undoCmd = undoList.pop();
            undoCmd.undo();
        }


    }
}

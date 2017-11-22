package com.test.demo.command;

import com.test.demo.provider.StackProvider;

import java.util.Stack;

public class ClearCommand extends Command{

    private Stack<Double> stack = new Stack<>();

    @Override
    public void execute() {
        Double e;
        while((e = StackProvider.pop())!= null)
            stack.push(e);
    }

    @Override
    public void undo() throws Exception {
        while(!stack.isEmpty())
            StackProvider.push(stack.pop());
    }


}

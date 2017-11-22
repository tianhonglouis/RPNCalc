package com.test.demo.command;

import com.test.demo.exception.InsufficientParamException;
import com.test.demo.provider.StackProvider;

public class SqrtCommand extends Command{
    private Double one;
    @Override
    public void execute() throws Exception{
        one = StackProvider.pop();
        if(one == null )
            throw new InsufficientParamException("sqrt", 5);
        StackProvider.push(Math.sqrt(one));
    }

    public void undo() throws Exception{
        StackProvider.pop();
        StackProvider.push(one);
    }
}

package com.test.demo.command;

import com.test.demo.exception.InsufficientParamException;
import com.test.demo.provider.StackProvider;

public class SubCommand extends Command{
    private Double one ;
    private Double two;

    @Override
    public void execute() throws Exception{
        one = StackProvider.pop();
        two = StackProvider.pop();

        if(one == null){
            throw new InsufficientParamException("-", 5);
        }
        else if(two == null){
            StackProvider.push(one);
            throw new InsufficientParamException("-", 5);
        }
        StackProvider.push(two-one);
    }

    public void undo() throws Exception{
        StackProvider.pop();
        StackProvider.push(two);
        StackProvider.push(one);
    }
}

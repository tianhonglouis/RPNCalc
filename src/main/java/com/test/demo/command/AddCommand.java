package com.test.demo.command;

import com.test.demo.exception.InsufficientParamException;
import com.test.demo.provider.StackProvider;

public class AddCommand extends Command{

    private Double one ;
    private Double two;

    @Override
    public void execute() throws Exception{
        one = StackProvider.pop();
        two = StackProvider.pop();

        if(one == null){
            //Todo:  postion is not clear in requirement, so here set it as default value -1
            throw new InsufficientParamException("+", -1);
        }
        else if(two == null){
            StackProvider.push(one);
            throw new InsufficientParamException("+", -1);
        }

        StackProvider.push(two + one);
    }

    @Override
    public void undo() throws Exception{
        StackProvider.pop();
        StackProvider.push(two);
        StackProvider.push(one);
    }


}

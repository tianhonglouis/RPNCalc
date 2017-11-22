package com.test.demo.command;

import com.test.demo.provider.StackProvider;

public class PushCommand extends Command{

    private Double one ;

    public PushCommand(Double e){
        this.one = e;
    }

    @Override
    public void execute() throws Exception{
        StackProvider.push(one);
    }

    @Override
    public void undo() throws Exception{
        StackProvider.pop();
    }


}

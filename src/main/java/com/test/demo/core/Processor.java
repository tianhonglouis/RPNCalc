package com.test.demo.core;

import com.test.demo.command.*;
import com.test.demo.exception.UnknownOperatorException;
import org.apache.commons.lang3.StringUtils;

public class Processor {

    private CmdInvoker invoker;

    public void setCommandInvoker(CmdInvoker invoker){
        this.invoker = invoker;
    }

    public Processor process(String line) throws Exception{
        String[] ops = line.split("\\s+");

        for(String op: ops){
            if(op.equals("+")){
                invoker.setCommand(new AddCommand());
                invoker.execute();
            }
            else if(op.equals("-")){
                invoker.setCommand(new SubCommand());
                invoker.execute();
            }
            else if(op.equals("*")){
                invoker.setCommand(new MulCommand());
                invoker.execute();
            }
            else if(op.equals("/")){
                invoker.setCommand(new DivCommand());
                invoker.execute();
            }
            else if(op.equals("sqrt")){
                invoker.setCommand(new SqrtCommand());
                invoker.execute();
            }
            else if(op.equals("undo")){
                invoker.undo();
            }
            else if(op.equals("clear")){
                invoker.setCommand(new ClearCommand());
                invoker.execute();
            }
            else if(StringUtils.isNumeric(op)){
                invoker.setCommand(new PushCommand(Double.valueOf(op)));
                invoker.execute();
            }
            else
                throw new UnknownOperatorException(op);
        }
        return this;
    }


}

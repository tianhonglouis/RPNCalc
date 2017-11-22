package com.test.demo.provider;

import com.test.demo.utils.FormatPrint;

import java.util.Stack;

public class StackProvider {

    private static Stack<Double> stack = new Stack<>();

    private StackProvider(){
    }

    public static synchronized void push(Double e){
        stack.push(e);
    }

    public static synchronized Double pop(){
        if(stack.isEmpty())
            return null;
        return stack.pop();
    }

    public static synchronized void clear(){
        stack.clear();
    }

    public static synchronized Stack<Double> getStack(){
        return stack;
    }
}

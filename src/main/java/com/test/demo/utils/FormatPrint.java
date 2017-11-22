package com.test.demo.utils;

import java.text.DecimalFormat;
import java.util.Stack;

public class FormatPrint {

    public static String format(double e){
        DecimalFormat df = new DecimalFormat("0.##########");
        return df.format(e);
    }

    public static void printStack(Stack<Double> stack){
        System.out.print("stack: ");
        stack.forEach(e -> System.out.print(FormatPrint.format(e) + " "));
        System.out.println();
    }
}

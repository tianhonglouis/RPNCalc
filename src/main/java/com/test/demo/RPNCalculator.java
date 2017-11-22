package com.test.demo;

import com.test.demo.command.CmdInvoker;
import com.test.demo.core.Processor;
import com.test.demo.provider.StackProvider;
import com.test.demo.utils.FormatPrint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RPNCalculator {

    public static void main(String []args) throws IOException {

        Processor processor = new Processor();
        processor.setCommandInvoker(new CmdInvoker());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while((line = reader.readLine()) != null){
            try {
                processor.process(line);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            FormatPrint.printStack(StackProvider.getStack());
        }

    }
}

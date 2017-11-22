package com.test.demo.exception;

public class UnknownOperatorException extends Exception{

    public UnknownOperatorException(String operator){
        super(String.format("Unknown operator:  %s", operator));
    }
}

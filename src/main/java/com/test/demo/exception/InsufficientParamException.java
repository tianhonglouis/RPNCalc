package com.test.demo.exception;

public class InsufficientParamException extends Exception{

    public InsufficientParamException(String operator, int pos){
        super(String.format("operator %s (position: %d): insufficient parameters", operator, pos));
    }
}

package com.test.demo.command;

public abstract class Command {

    public abstract void execute() throws Exception;
    public abstract void undo() throws Exception;
}

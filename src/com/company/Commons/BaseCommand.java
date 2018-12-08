package com.company.Commons;

import com.company.Interfaces.ICommand;

import java.util.Vector;

public class BaseCommand implements ICommand {
    private String description = null;
    private String header = null;

    public BaseCommand(String name, String description) {
        this.header = name;
        this.description = description;
    }

    protected String action(String body) {
        //@Override this method
        //TODO YOUR COMMAND
        //See also RabbitsCleanUpCommand
        return "Ok";
    }

    @Override
    public boolean isMatch(String header, String body) {
        boolean isMyName = this.header.equals(header);
        //if (isMyName) action(body);
        return isMyName;
    }

    @Override
    public String getName() {
        return header;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
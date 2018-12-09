package com.company.Common.Commons;

import com.company.Common.Interfaces.ICommand;

public class BaseCommand<TResult> implements ICommand<String, TResult> {
    private String description = null;
    private String header = null;

    public BaseCommand(String name, String description) {
        this.header = name;
        this.description = description;
    }

    @Override
    public TResult action(String body) {
        //@Override this method
        //TODO YOUR COMMAND
        //See also RabbitsCleanUpCommand
        return null;
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
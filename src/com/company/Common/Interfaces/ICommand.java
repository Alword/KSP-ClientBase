package com.company.Common.Interfaces;

public interface ICommand<CommandParam,CommandResult> {
    boolean isMatch(String header, String body);

    String getName();

    String getDescription();

    CommandResult action(CommandParam body);
}
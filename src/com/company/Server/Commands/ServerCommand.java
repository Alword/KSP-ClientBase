package com.company.Server.Commands;

import com.company.Common.Commons.BaseCommand;

import java.util.Vector;

public class ServerCommand extends BaseCommand<String> {
    private static Vector<ServerCommand> ServerCommands = null;

    public ServerCommand(String name, String description) {
        super(name, description);
        if (ServerCommands == null) {
            ServerCommands = new Vector<>();
        }
        ServerCommands.add(this);
    }

    @Override
    public String action(String body) {
        //@Override this method
        //TODO YOUR COMMAND
        //See also RabbitsCleanUpCommand
        return "Ok";
    }

    public static String invokeCommands(String header, String context) {
        for (ServerCommand command :
                ServerCommands) {
            if (command.isMatch(header, context)) {
                try {
                    return command.action(context);
                } catch (Exception ex) {
                    String error = "422 Unprocessable Entity in " +
                            "request header: " + header +
                            "request context: " + context;
                    System.out.println(error);
                    return error;
                }
            }
        }
        return "404";
    }

    public static String invokeCommands(String headerSharpContext) {
        int sharpIndex = headerSharpContext.indexOf("#");
        try {
            String header = headerSharpContext.substring(0, sharpIndex);
            String context = headerSharpContext.substring(sharpIndex + 1);
            return invokeCommands(header, context);
        } catch (Exception ex) {
            return "400 Bad request";
        }
    }
}
package com.company.Server.Commands.DirectCommands.CreateCommands;

import com.company.Models.Domains.EmployeeGroup;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

public class AddEmployeeGroupCommand extends ServerCommand {
    Gson gson = null;

    public AddEmployeeGroupCommand() {
        super("AddEmployeeGroupCommand", "AddEmployeeGroupCommand");
        gson = new Gson();
    }

    @Override
    protected String action(String body) {
        try {
            EmployeeGroup entity = gson.fromJson(body, EmployeeGroup.class);
            entity = IOC.EmployeeGroupsRepository.create(entity);
            String answer = gson.toJson(entity);
            return answer;
        } catch (Exception ex) {
            return "422 Unprocessable Entity";
        }
    }
}

package com.company.Server.Commands.DirectCommands.CreateCommands;

import com.company.Common.Models.Domains.Employee;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

public class AddEmployeeCommand extends ServerCommand {
    Gson gson = null;

    public AddEmployeeCommand() {
        super("AddEmployeeCommand", "AddEmployeeCommand");
        gson = new Gson();
    }

    @Override
    public String action(String body) {
        Employee entity = gson.fromJson(body, Employee.class);
        entity = IOC.EmployeesRepository.create(entity);
        String answer = gson.toJson(entity);
        return answer;
    }
}

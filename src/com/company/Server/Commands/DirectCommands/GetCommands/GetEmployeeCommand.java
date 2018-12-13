package com.company.Server.Commands.DirectCommands.GetCommands;

import com.company.Common.Models.Domains.Client;
import com.company.Common.Models.Domains.Employee;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

import java.util.List;

public class GetEmployeeCommand extends ServerCommand {
    Gson gson = null;

    public GetEmployeeCommand() {
        super("GetEmployeeCommand", "GetEmployeeCommand");
        gson = new Gson();
    }

    @Override
    public String action(String body) {
        if (body.equals("all")) {
            List<Employee> employeeList = IOC.EmployeesRepository.get();
            return gson.toJson(employeeList);
        } else {
            List<Employee> employees = IOC.EmployeesRepository.get(c -> c.Key == Integer.parseInt(body));
            Employee requestEmployee = employees.get(0);
            String answer = gson.toJson(requestEmployee);
            return answer;
        }
    }
}

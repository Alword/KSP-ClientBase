package com.company.ServerApi.Controllers.DirectController;

import com.company.Common.Models.Domains.Employee;
import com.company.ServerApi.Controllers.ServerApiController;
import com.company.ServerApi.Models.Connection;

public class EmployeeDirectController extends ServerApiController<Employee, Employee> {

    public EmployeeDirectController(Connection connection) {
        super(connection);
    }

    @Override
    public Employee create(Employee body) {
        String json = gson.toJson(body);
        json = connection.sendMsg("AddEmployeeCommand#" + json);
        body = gson.fromJson(json, Employee.class);
        return body;
    }
}
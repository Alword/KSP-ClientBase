package com.company.ServerApi.Controllers.DirectController;

import com.company.Common.Models.Domains.Client;
import com.company.Common.Models.Domains.Employee;
import com.company.ServerApi.Controllers.ServerApiController;
import com.company.ServerApi.Models.Connection;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

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

    public List<Employee> getAll() {
        String json = connection.sendMsg("GetEmployeeCommand#all");
        Type typeOfT = new TypeToken<Collection<Employee>>() {
        }.getType();
        List<Employee> employees = gson.fromJson(json, typeOfT);
        return employees;
    }

    //TODO как это сделать?
    public static <T> Type getType() {
        return new TypeToken<T>() {
        }.getType();
    }
}
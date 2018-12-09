package com.company.ServerApi.Controllers.DirectController;

import com.company.Common.Models.Domains.Email;
import com.company.Common.Models.Domains.Employee;
import com.company.ServerApi.Controllers.ServerApiController;
import com.company.ServerApi.Models.Connection;

public class EmailDirectController extends ServerApiController<Email, Email> {

    public EmailDirectController(Connection connection) {
        super(connection);
    }

    @Override
    public Email create(Email body) {
        String json = gson.toJson(body);
        json = connection.sendMsg("AddEmailCommand#" + json);
        body = gson.fromJson(json, Email.class);
        return body;
    }
}
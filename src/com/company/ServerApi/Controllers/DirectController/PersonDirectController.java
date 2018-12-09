package com.company.ServerApi.Controllers.DirectController;

import com.company.Common.Models.Domains.Person;
import com.company.ServerApi.Controllers.ServerApiController;
import com.company.ServerApi.Models.Connection;

public class PersonDirectController extends ServerApiController<Person, Person> {

    public PersonDirectController(Connection connection) {
        super(connection);
    }

    @Override
    public Person create(Person body) {
        String json = gson.toJson(body);
        json = connection.sendMsg("AddPersonCommand#" + json);
        body = gson.fromJson(json, Person.class);
        return body;
    }
}
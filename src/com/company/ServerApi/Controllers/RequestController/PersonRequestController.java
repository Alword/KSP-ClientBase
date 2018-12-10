package com.company.ServerApi.Controllers.RequestController;

import com.company.Common.Models.Domains.Address;
import com.company.Common.Models.Domains.Email;
import com.company.Common.Models.Domains.Person;
import com.company.Common.Models.Domains.Phone;
import com.company.Common.Models.Requests.PersonRequest;
import com.company.ServerApi.Controllers.DirectController.AddressDirectController;
import com.company.ServerApi.Controllers.DirectController.EmailDirectController;
import com.company.ServerApi.Controllers.DirectController.PersonDirectController;
import com.company.ServerApi.Controllers.DirectController.PhoneDirectController;
import com.company.ServerApi.Controllers.ServerApiController;
import com.company.ServerApi.Models.Connection;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class PersonRequestController extends ServerApiController<PersonRequest, PersonRequest> {

    public PersonRequestController(Connection connection) {
        super(connection);
    }

    @Override
    public PersonRequest create(PersonRequest body) {
        String json = gson.toJson(body);
        json = connection.sendMsg("AddPersonRequestCommand#" + json);
        body = gson.fromJson(json, PersonRequest.class);
        return body;
    }

    public List<PersonRequest> getAll() {
        String json = connection.sendMsg("GetPersonRequestCommand#all");
        Type typeOfT = new TypeToken<Collection<PersonRequest>>() {
        }.getType();
        List<PersonRequest> personRequestList = gson.fromJson(json, typeOfT);
        return personRequestList;
    }
}

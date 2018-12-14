package com.company.ServerApi.Controllers.RequestController;

import com.company.Common.Models.Requests.PersonRequest;
import com.company.ServerApi.Controllers.ServerApiController;
import com.company.ServerApi.Models.Connection;
import com.google.gson.reflect.TypeToken;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class ContractRequestController extends ServerApiController<PersonRequest, PersonRequest> {

    public ContractRequestController(Connection connection) {
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
        //String json = connection.sendMsg("GetPersonRequestCommand#all");
        //Type typeOfT = new TypeToken<Collection<PersonRequest>>() {
        //}.getType();
        //List<PersonRequest> personRequestList = gson.fromJson(json, typeOfT);
        //return personRequestList;
        throw new NotImplementedException();
    }

    public PersonRequest getByID(Integer id) {
        throw new NotImplementedException();
    }

    public void deleteByID(Integer id) {
        throw new NotImplementedException();
        //String json = connection.sendMsg("DeletePersonRequestCommand#" + id.toString());
    }
}

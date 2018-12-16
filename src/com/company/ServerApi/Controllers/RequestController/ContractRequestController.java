package com.company.ServerApi.Controllers.RequestController;

import com.company.Common.Models.Requests.PersonRequest;
import com.company.Common.Models.Requests.ServiceContractRequest;
import com.company.ServerApi.Controllers.ServerApiController;
import com.company.ServerApi.Models.Connection;
import com.google.gson.reflect.TypeToken;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class ContractRequestController extends ServerApiController<ServiceContractRequest, ServiceContractRequest> {

    public ContractRequestController(Connection connection) {
        super(connection);
    }

    @Override
    public ServiceContractRequest create(ServiceContractRequest body) {
        String json = gson.toJson(body);
        json = connection.sendMsg("AddContractRequestCommand#" + json);
        body = gson.fromJson(json, ServiceContractRequest.class);
        return body;
    }

    public List<ServiceContractRequest> getAll() {
        String json = connection.sendMsg("GetContractRequestCommand#all");
        Type typeOfT = new TypeToken<Collection<ServiceContractRequest>>() {
        }.getType();
        List<ServiceContractRequest> serviceContractRequest = gson.fromJson(json, typeOfT);
        return serviceContractRequest;
    }

    public PersonRequest getByID(Integer id) {
        throw new NotImplementedException();
    }

    public void deleteByID(Integer id) {
        throw new NotImplementedException();
        //String json = connection.sendMsg("DeletePersonRequestCommand#" + id.toString());
    }
}

package com.company.ServerApi.Controllers.DirectController;

import com.company.Common.Models.Domains.Address;
import com.company.Common.Models.Domains.Client;
import com.company.ServerApi.Controllers.ServerApiController;
import com.company.ServerApi.Models.Connection;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class ClientDirectController extends ServerApiController<Client, Client> {

    public ClientDirectController(Connection connection) {
        super(connection);
    }

    @Override
    public Client create(Client body) {
        String json = gson.toJson(body);
        json = connection.sendMsg("AddClientCommand#" + json);
        body = gson.fromJson(json, Client.class);
        return body;
    }

    public List<Client> getAll() {
        String json = connection.sendMsg("GetClientCommand#all");
        Type typeOfT = new TypeToken<Collection<Client>>() {
        }.getType();
        List<Client> clients = gson.fromJson(json, typeOfT);
        return clients;
    }
}
package com.company.Server.Commands.DirectCommands.GetCommands;

import com.company.Common.Commons.BaseRepository;
import com.company.Common.Commons.DomainObject;
import com.company.Common.Models.Domains.Client;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.corba.se.spi.activation.Repository;
import com.sun.corba.se.spi.activation.Server;

import java.lang.reflect.Type;
import java.util.List;

public class BaseGetCommand<Entity extends DomainObject> extends ServerCommand {

    Gson gson = null;
    BaseRepository<Entity> repository = null;
    Type type;

    public BaseGetCommand(String getEntityCommandName, BaseRepository<Entity> repository, Type type) {
        super(getEntityCommandName, getEntityCommandName);
        gson = new Gson();
        this.repository = repository;
        this.type = type;
    }

    @Override
    public String action(String body) {
        if (body.equals("all")) {
            List<Entity> clientList = repository.get();
            return gson.toJson(clientList);
        } else {
            List<Entity> entities = repository.get(c -> c.Key == Integer.parseInt(body));
            Entity requestEntity = entities.get(0);
            Type type = new TypeToken<Entity>() {}.getType();
            return gson.toJson(requestEntity,type);
        }
    }
}

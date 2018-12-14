package com.company.Server.Commands.DirectCommands.CreateCommands;

import com.company.Common.Commons.BaseRepository;
import com.company.Common.Commons.DomainObject;
import com.company.Common.Models.Domains.Address;
import com.company.Common.Models.Domains.Client;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.corba.se.spi.activation.Repository;

import java.lang.reflect.Type;

import static com.company.Common.Commons.BaseRepository.*;

public class BaseAddCommand<Entity extends DomainObject> extends ServerCommand {

    private Gson gson = null;
    private Type type;
    private BaseRepository<Entity> repository;

    public BaseAddCommand(String commandName, BaseRepository repository, Type type) {
        super(commandName, commandName);
        gson = new Gson();
        this.repository = repository;
        this.type = type;
    }

    @Override
    public String action(String body) {
        Entity entity = gson.fromJson(body, type);
        entity = repository.create(entity);
        return gson.toJson(entity);
    }
}

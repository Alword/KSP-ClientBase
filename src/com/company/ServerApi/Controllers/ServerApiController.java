package com.company.ServerApi.Controllers;

import com.company.Common.Interfaces.ICommand;
import com.company.ServerApi.Models.Connection;
import com.google.gson.Gson;

public class ServerApiController<Param, Result>{

    protected Gson gson = null;
    protected Connection connection = null;

    public ServerApiController(Connection connection) {
        this.connection = connection;
        this.gson = new Gson();
    }

    public Result create(Param body) {
        return null;
    }
}

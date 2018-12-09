package com.company.Server.Commands.DirectCommands.CreateCommands;

import com.company.Common.Models.Domains.Client;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

public class AddClientCommand extends ServerCommand {
    Gson gson = null;

    public AddClientCommand() {
        super("AddClientCommand", "AddClientCommand");
        gson = new Gson();
    }

    @Override
    public String action(String body) {
        try {
            Client entity = gson.fromJson(body, Client.class);
            entity = IOC.ClientsRepository.create(entity);
            String answer = gson.toJson(entity);
            return answer;
        } catch (Exception ex) {
            return "422 Unprocessable Entity";
        }
    }
}

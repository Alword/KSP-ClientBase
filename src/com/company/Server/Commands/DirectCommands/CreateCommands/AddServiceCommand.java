package com.company.Server.Commands.DirectCommands.CreateCommands;

import com.company.Common.Models.Domains.Service;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

public class AddServiceCommand extends ServerCommand {
    Gson gson = null;

    public AddServiceCommand() {
        super("AddServiceCommand", "AddServiceCommand");
        gson = new Gson();
    }

    @Override
    public String action(String body) {
        try {
            Service entity = gson.fromJson(body, Service.class);
            entity = IOC.ServicesRepository.create(entity);
            String answer = gson.toJson(entity);
            return answer;
        } catch (Exception ex) {
            return "422 Unprocessable Entity";
        }
    }
}

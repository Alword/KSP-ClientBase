package com.company.Server.Commands.DirectCommands.CreateCommands;

import com.company.Common.Models.Domains.ServiceContract;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

public class AddServiceContractCommand extends ServerCommand {
    Gson gson = null;

    public AddServiceContractCommand() {
        super("AddServiceContractCommand", "AddServiceContractCommand");
        gson = new Gson();
    }

    @Override
    public String action(String body) {
        ServiceContract entity = gson.fromJson(body, ServiceContract.class);
        entity = IOC.ServiceContractsRepository.create(entity);
        String answer = gson.toJson(entity);
        return answer;
    }
}

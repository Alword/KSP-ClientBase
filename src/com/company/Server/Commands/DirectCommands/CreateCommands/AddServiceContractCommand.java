package com.company.Server.Commands.DirectCommands.CreateCommands;

import com.company.Models.Domains.OrganizationWorker;
import com.company.Models.Domains.ServiceContract;
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
    protected String action(String body) {
        try {
            ServiceContract entity = gson.fromJson(body, ServiceContract .class);
            entity = IOC.ServiceContractsRepository.create(entity);
            String answer = gson.toJson(entity);
            return answer;
        } catch (Exception ex) {
            return "422 Unprocessable Entity";
        }
    }
}

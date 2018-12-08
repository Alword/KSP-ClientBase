package com.company.Server.Commands.DirectCommands.CreateCommands;

import com.company.Models.Domains.Email;
import com.company.Models.Domains.OrganizationWorker;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

public class AddOrganizationWorkerCommand extends ServerCommand {
    Gson gson = null;

    public AddOrganizationWorkerCommand() {
        super("AddOrganizationWorker", "AddOrganizationWorker");
        gson = new Gson();
    }

    @Override
    protected String action(String body) {
        try {
            OrganizationWorker entity = gson.fromJson(body, OrganizationWorker.class);
            entity = IOC.OrganizationWorkersRepository.create(entity);
            String answer = gson.toJson(entity);
            return answer;
        } catch (Exception ex) {
            return "422 Unprocessable Entity";
        }
    }
}

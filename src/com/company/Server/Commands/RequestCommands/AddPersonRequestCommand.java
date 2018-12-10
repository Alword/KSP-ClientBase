package com.company.Server.Commands.RequestCommands;

import com.company.Common.Models.Domains.Address;
import com.company.Common.Models.Requests.PersonRequest;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

public class AddPersonRequestCommand extends ServerCommand {
    Gson gson = null;

    public AddPersonRequestCommand() {
        super("AddPersonRequestCommand", "AddPersonRequestCommand");
        gson = new Gson();
    }

    @Override
    public String action(String body) {
        try {
            PersonRequest personRequest = gson.fromJson(body, PersonRequest.class);
            personRequest = IOC.PersonsRepository.create(personRequest);
            String answer = gson.toJson(personRequest);
            return answer;
        } catch (Exception ex) {
            return "422 Unprocessable Entity";
        }
    }
}
package com.company.Server.Commands.RequestCommands;

import com.company.Common.Models.Requests.PersonRequest;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

import java.util.List;

public class GetPersonRequestCommand extends ServerCommand {
    Gson gson = null;

    public GetPersonRequestCommand() {
        super("GetPersonRequestCommand", "GetPersonRequestCommand");
        gson = new Gson();
    }

    @Override
    public String action(String body) {
        try {
            if (body.equals("all")) {
                List<PersonRequest> personRequest = IOC.PersonsRepository.getInclude();
                String answer = gson.toJson(personRequest);
                return answer;
            } else {
                return null;
            }
        } catch (Exception ex) {
            return "422 Unprocessable Entity";
        }
    }
}
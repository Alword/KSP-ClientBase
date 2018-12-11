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
        if (body.equals("all")) {
            return getAll();
        } else {
            return getByID(body);
        }
    }

    private String getAll() {
        List<PersonRequest> personRequest = IOC.PersonsRepository.getInclude();
        String answer = gson.toJson(personRequest);
        return answer;
    }

    private String getByID(String idString) {
        Integer id = Integer.parseInt(idString);
        return getByID(id);
    }

    private String getByID(Integer id) {
        PersonRequest personRequest = IOC.PersonsRepository.getInclude(id);
        String answer = gson.toJson(personRequest);
        return answer;
    }
}
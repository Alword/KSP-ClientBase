package com.company.Server.Commands.RequestCommands;

import com.company.Common.Models.Requests.ServiceContractRequest;
import com.company.Common.Models.Requests.PersonRequest;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class GetContractRequestCommand extends ServerCommand {
    Gson gson = null;

    public GetContractRequestCommand() {
        super("GetContractRequestCommand", "GetContractRequestCommand");
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
        List<ServiceContractRequest> personRequest = IOC.ServiceContractsRepository.getInclude();
        String answer = gson.toJson(personRequest);
        return answer;
    }

    private String getByID(String idString) {
        Integer id = Integer.parseInt(idString);
        throw new NotImplementedException();
        //return getByID(id);
    }

    private String getByID(Integer id) {
        PersonRequest personRequest = IOC.PersonsRepository.getInclude(id);
        String answer = gson.toJson(personRequest);
        throw new NotImplementedException();
        //return answer;
    }
}
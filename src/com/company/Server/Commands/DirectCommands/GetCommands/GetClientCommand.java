package com.company.Server.Commands.DirectCommands.GetCommands;

import com.company.Common.Models.Domains.Client;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jdk.nashorn.internal.parser.Token;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class GetClientCommand extends ServerCommand {
    Gson gson = null;

    public GetClientCommand() {
        super("GetClientCommand", "GetClientCommand");
        gson = new Gson();
    }

    @Override
    public String action(String body) {
        if (body.equals("all")) {
            List<Client> clientList = IOC.ClientsRepository.get();
            return gson.toJson(clientList);
        } else {
            List<Client> clients = IOC.ClientsRepository.get(c -> c.Key == Integer.parseInt(body));
            Client requestClient = clients.get(0);
            String answer = gson.toJson(requestClient);
            return answer;
        }
    }
}

package com.company.Server.Commands.DirectCommands.CreateCommands;

import com.company.Common.Models.Domains.Address;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

public class AddAddressCommand extends ServerCommand {
    Gson gson = null;

    public AddAddressCommand() {
        super("AddAddressCommand", "AddAddressCommand");
        gson = new Gson();
    }

    @Override
    public String action(String body) {
        Address аddress = gson.fromJson(body, Address.class);
        аddress = IOC.AddressesRepository.create(аddress);
        String answer = gson.toJson(аddress);
        return answer;
    }
}

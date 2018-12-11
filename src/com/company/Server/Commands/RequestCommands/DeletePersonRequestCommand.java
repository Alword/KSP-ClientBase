package com.company.Server.Commands.RequestCommands;

import com.company.Common.Commons.DomainObject;
import com.company.Common.Models.Domains.Address;
import com.company.Common.Models.Domains.Email;
import com.company.Common.Models.Domains.Phone;
import com.company.Common.Models.Requests.PersonRequest;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

import java.util.List;
import java.util.Vector;

public class DeletePersonRequestCommand extends ServerCommand {
    Gson gson = null;

    public DeletePersonRequestCommand() {
        super("DeletePersonRequestCommand", "DeletePersonRequestCommand");
        gson = new Gson();
    }

    @Override
    public String action(String body) {
        Integer id = Integer.parseInt(body);
        IOC.PersonsRepository.remove(id);
        IOC.EmailsRepository.get(e -> e.PersonID == id)
                .forEach(e -> IOC.EmailsRepository.remove(e.Key));
        IOC.AddressesRepository.get(a -> a.PersonID == id)
                .forEach(a -> IOC.AddressesRepository.remove(a.Key));
        IOC.PhonesRepository.get(phone -> phone.PersonID == id)
                .forEach(p -> IOC.PhonesRepository.remove(p.Key));
        return "Success delete Person on id: " + body;
    }
}
package com.company.Server.Commands.DirectCommands.CreateCommands;

import com.company.Common.Models.Domains.Person;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

public class AddPersonCommand extends ServerCommand {

    Gson gson = null;

    public AddPersonCommand() {
        super("AddPersonCommand", "AddPersonCommand");
        gson = new Gson();
    }

    @Override
    public String action(String body) {
        Person person = gson.fromJson(body, Person.class);
        person = IOC.PersonsRepository.create(person);
        String answer = gson.toJson(person);
        return answer;
    }
}

package com.company.Server.Commands.DirectCommands.CreateCommands;

import com.company.Models.Domains.Email;
import com.company.Models.Domains.Person;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

public class AddEmailCommand extends ServerCommand {
    Gson gson = null;

    public AddEmailCommand() {
        super("AddEmailCommand", "AddEmailCommand");
        gson = new Gson();
    }

    @Override
    protected String action(String body) {
        try {
            Email email = gson.fromJson(body, Email.class);
            email = IOC.EmailsRepository.create(email);
            String answer = gson.toJson(email);
            return answer;
        } catch (Exception ex) {
            return "422 Unprocessable Entity";
        }
    }
}

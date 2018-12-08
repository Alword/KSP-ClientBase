package com.company.Server.Commands.DirectCommands.CreateCommands;

import com.company.Models.Domains.Email;
import com.company.Models.Domains.Phone;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

public class AddPhoneCommand extends ServerCommand {
    Gson gson = null;

    public AddPhoneCommand() {
        super("AddPhone", "AddPhone");
        gson = new Gson();
    }

    @Override
    protected String action(String body) {
        try {
            Phone phone = gson.fromJson(body,Phone.class);
            phone = IOC.PhonesRepository.create(phone);
            String answer = gson.toJson(phone);
            return answer;
        } catch (Exception ex) {
            return "422 Unprocessable Entity";
        }
    }
}

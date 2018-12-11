package com.company.Server.Commands.DirectCommands.CreateCommands;

import com.company.Common.Models.Domains.Phone;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

public class AddPhoneCommand extends ServerCommand {
    Gson gson = null;

    public AddPhoneCommand() {
        super("AddPhoneCommand", "AddPhoneCommand");
        gson = new Gson();
    }

    @Override
    public String action(String body) {
        Phone phone = gson.fromJson(body, Phone.class);
        phone = IOC.PhonesRepository.create(phone);
        String answer = gson.toJson(phone);
        return answer;
    }
}

package com.company.Server.Models;

import com.company.Common.Models.Domains.Client;
import com.company.Common.Models.Domains.Employee;
import com.company.Server.Commands.DirectCommands.CreateCommands.*;
import com.company.Server.Commands.DirectCommands.GetCommands.BaseGetCommand;
import com.company.Server.Commands.DirectCommands.GetCommands.GetClientCommand;
import com.company.Server.Commands.RequestCommands.*;
import com.company.Server.IOC;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;

public class Mapping {
    public Mapping() {
        commandMapping();
    }

    private void commandMapping() {
        DirectCommands();
        RequestAddCommands();
    }

    private void DirectCommands() {
        new AddAddressCommand();

        new AddClientCommand();
        //new GetClientCommand();
        Type clientType = new TypeToken<Client>() {}.getType();
        new BaseGetCommand("GetClientCommand", IOC.ClientsRepository, clientType);
        new AddEmailCommand();
        new AddEmployeeCommand();
        new AddEmployeeGroupCommand();
        new AddOrganizationWorkerCommand();
        new AddPersonCommand();
        new AddPhoneCommand();
        new AddServiceCommand();
        new AddServiceContractCommand();
    }

    private void RequestAddCommands() {
        new AddPersonRequestCommand();
        new GetPersonRequestCommand();
        new DeletePersonRequestCommand();
    }
}
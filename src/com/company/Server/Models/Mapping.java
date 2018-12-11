package com.company.Server.Models;

import com.company.Server.Commands.DirectCommands.CreateCommands.*;
import com.company.Server.Commands.RequestCommands.*;

public class Mapping {
    public Mapping() {
        commandMapping();
    }

    private void commandMapping() {
        DirectAddCommands();
        RequestAddCommands();
    }

    private void DirectAddCommands() {
        new AddAddressCommand();
        new AddClientCommand();
        new AddEmailCommand();
        new AddEmployeeCommand();
        new AddEmployeeGroupCommand();
        new AddOrganizationWorkerCommand();
        new AddPersonCommand();
        new AddPhoneCommand();
        new AddServiceCommand();
        new AddServiceContractCommand();
    }
    private void RequestAddCommands(){
        new AddPersonRequestCommand();
        new GetPersonRequestCommand();
        new DeletePersonRequestCommand();
    }
}
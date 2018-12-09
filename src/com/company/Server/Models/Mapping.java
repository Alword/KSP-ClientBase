package com.company.Server.Models;

import com.company.Server.Commands.DirectCommands.CreateCommands.*;

public class Mapping {
    public Mapping() {
        commandMapping();
    }

    private void commandMapping() {
        DirectAddCommands();
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
}
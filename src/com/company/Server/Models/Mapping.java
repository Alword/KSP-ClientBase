package com.company.Server.Models;

import com.company.Common.Models.Domains.*;
import com.company.Server.Commands.DirectCommands.CreateCommands.*;
import com.company.Server.Commands.DirectCommands.GetCommands.BaseGetCommand;
import com.company.Server.Commands.RequestCommands.*;
import com.company.Server.IOC;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class Mapping {
    public Mapping() {
        commandMapping();
    }

    private void commandMapping() {
        DirectCommands();
        RequestAddCommands();
    }

    private void DirectCommands() {
        Type typOfAddress = new TypeToken<Address>() {
        }.getType();
        Type typOfClient = new TypeToken<Client>() {
        }.getType();
        Type typOfEmail = new TypeToken<Email>() {
        }.getType();
        Type typOfEmployeeGroup = new TypeToken<EmployeeGroup>() {
        }.getType();
        Type typOfEmployee = new TypeToken<Employee>() {
        }.getType();
        Type typOfOrganizationWorker = new TypeToken<OrganizationWorker>() {
        }.getType();
        Type typOfPerson = new TypeToken<Person>() {
        }.getType();
        Type typOfPhone = new TypeToken<Phone>() {
        }.getType();

        Type typOfServiceContract = new TypeToken<ServiceContract>() {
        }.getType();
        Type typOfService = new TypeToken<Service>() {
        }.getType();
        new BaseAddCommand<>("AddAddressCommand", IOC.AddressesRepository, typOfAddress);
        new BaseAddCommand<>("AddClientCommand", IOC.ClientsRepository, typOfClient);
        new BaseAddCommand<>("AddEmailCommand", IOC.EmailsRepository, typOfEmail);
        new BaseAddCommand<>("AddEmployeeCommand", IOC.EmployeesRepository, typOfEmployee);
        new BaseAddCommand<>("AddEmployeeGroupCommand", IOC.EmployeeGroupsRepository, typOfEmployeeGroup);
        new BaseAddCommand<>("AddOrganizationWorkerCommand", IOC.OrganizationWorkersRepository, typOfOrganizationWorker);
        new BaseAddCommand<>("AddPersonCommand", IOC.PersonsRepository, typOfPerson);
        new BaseAddCommand<>("AddPhoneCommand", IOC.PhonesRepository, typOfPhone);
        new BaseAddCommand<>("AddServiceCommand", IOC.ServicesRepository, typOfService);
        new BaseAddCommand<>("AddServiceContractCommand",
                IOC.ServiceContractsRepository,
                typOfServiceContract);
        new BaseGetCommand<>("GetClientCommand", IOC.ClientsRepository);
        new BaseGetCommand<>("GetEmployeeCommand", IOC.EmployeesRepository);
    }

    private void RequestAddCommands() {
        new AddPersonRequestCommand();
        new GetPersonRequestCommand();
        new DeletePersonRequestCommand();
    }
}
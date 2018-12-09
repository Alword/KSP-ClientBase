package com.company.Common.Models;

import com.company.Common.Models.Domains.*;

import java.util.List;
import java.util.Vector;

public class ClientBaseContext {
    public List<Address> Addresses;
    public List<Client> Clients;
    public List<Email> Emails;
    public List<Employee> Employees;
    public List<EmployeeGroup> EmployeeGroups;
    public List<OrganizationWorker> OrganizationWorkers;
    public List<Person> Persons;
    public List<Phone> Phones;
    public List<Service> Services;
    public List<ServiceContract> ServiceContracts;

    public ClientBaseContext() {
        Addresses = new Vector<>();
        Clients = new Vector<>();
        Emails = new Vector<>();
        Employees = new Vector<>();
        EmployeeGroups = new Vector<>();
        OrganizationWorkers = new Vector<>();
        Persons = new Vector<>();
        Phones = new Vector<>();
        Services = new Vector<>();
        ServiceContracts = new Vector<>();
    }
}
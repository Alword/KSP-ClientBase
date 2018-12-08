package com.company.Server;

import com.company.Models.ClientBaseContext;
import com.company.Models.Domains.Email;
import com.company.Models.Repositories.*;

import javax.xml.crypto.Data;

public class IOC {
    public static ClientBaseContext DatabaseInstance;
    public static AddressRepository AddressesRepository;
    public static ClientRepository ClientsRepository;
    public static EmailRepository EmailsRepository;
    public static EmployeeGroupRepository EmployeeGroupsRepository;
    public static EmployeeRepository EmployeesRepository;
    public static OrganizationWorkerRepository OrganizationWorkersRepository;
    public static PersonRepository PersonsRepository;
    public static PhoneRepository PhonesRepository;
    public static ServiceContractRepository ServiceContractsRepository;
    public static ServiceRepository ServicesRepository;

    public IOC() {
        DatabaseInstance = new ClientBaseContext();
        AddressesRepository = new AddressRepository(DatabaseInstance.Addresses);
        ClientsRepository = new ClientRepository(DatabaseInstance.Clients);
        EmailsRepository = new EmailRepository(DatabaseInstance.Emails);
        EmployeeGroupsRepository = new EmployeeGroupRepository(DatabaseInstance.EmployeeGroups);
        EmployeesRepository = new EmployeeRepository(DatabaseInstance.Employees);
        OrganizationWorkersRepository = new OrganizationWorkerRepository(DatabaseInstance.OrganizationWorkers);
        PersonsRepository = new PersonRepository(DatabaseInstance.Persons);
        PhonesRepository = new PhoneRepository(DatabaseInstance.Phones);
        ServiceContractsRepository = new ServiceContractRepository(DatabaseInstance.ServiceContracts);
        ServicesRepository = new ServiceRepository(DatabaseInstance.Services);
    }
}
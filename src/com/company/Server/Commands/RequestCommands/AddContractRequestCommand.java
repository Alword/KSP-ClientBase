package com.company.Server.Commands.RequestCommands;

import com.company.Common.Commons.BaseRepository;
import com.company.Common.Commons.DomainObject;
import com.company.Common.Models.Domains.*;
import com.company.Common.Models.Requests.ServiceContractRequest;
import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;
import com.google.gson.Gson;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class AddContractRequestCommand extends ServerCommand {
    Gson gson = null;

    public AddContractRequestCommand() {
        super("AddContractRequestCommand", "AddContractRequestCommand");
        gson = new Gson();
    }

    @Override
    public String action(String body) {
        // Получить апрос
        ServiceContractRequest serviceContractRequest = gson.fromJson(body, ServiceContractRequest.class);
        // Сформировать контракт
        ServiceContract contract = new ServiceContract();

        // Определить услугу
        Service service = new Service();
        service.Name = serviceContractRequest.Name;
        String contractName = service.Name;
        double contractPrice = service.Price;
        service.Price = serviceContractRequest.Price;
        List<Service> services =
                IOC.ServicesRepository.get(s -> s.Price == contractPrice && s.Name == contractName);
        service = singleOrCreate(service, services, IOC.ServicesRepository);
        contract.ServiceID = service.Key;

        //Определить клиента
        Integer clientKey = serviceContractRequest.ClientID;
        List<Client> clients = IOC.ClientsRepository.get(client1 -> client1.Key == clientKey);
        if (clients == null || clients.size() == 0)
            return "404 Client id not found: " + clientKey;
        contract.ClientID = clientKey;

        //Определить рабочих
        List<Employee> employeeList = new Vector<>();
        for (Integer workerID :
                serviceContractRequest.WorkerIDs) {
            List<Employee> employees = IOC.EmployeesRepository.get(employee -> employee.Key == workerID);
            if (employees != null && employees.size() > 0) {
                employeeList.add(employees.get(0));
            }
        }

        // Записать контракт
        contract.TimeStamp = System.currentTimeMillis();
        contract = IOC.ServiceContractsRepository.create(contract);

        // Создать рабочую группу для заказа
        for (Employee employee :
                employeeList) {
            EmployeeGroup groupPart = new EmployeeGroup();
            groupPart.ServiceContractID = contract.Key;
            groupPart.EmployeeID = employee.Key;
            IOC.EmployeeGroupsRepository.create(groupPart);
        }

        // Вернуть контракт
        String answer = gson.toJson(contract);
        return answer;
    }

    private static <E extends DomainObject> E singleOrCreate(E entity, List<E> list, BaseRepository<E> repository) {
        if (list != null && list.size() > 0) {
            entity = list.get(0);
        } else {
            entity = repository.create(entity);
        }
        return entity;
    }
}
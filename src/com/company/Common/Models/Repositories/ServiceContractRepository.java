package com.company.Common.Models.Repositories;

import com.company.Common.Commons.BaseRepository;
import com.company.Common.Models.Domains.EmployeeGroup;
import com.company.Common.Models.Domains.Service;
import com.company.Common.Models.Domains.ServiceContract;
import com.company.Common.Models.Requests.ServiceContractRequest;
import com.company.Common.Models.Requests.PersonRequest;
import com.company.Server.IOC;

import java.util.List;
import java.util.Vector;

public class ServiceContractRepository extends BaseRepository<ServiceContract> {
    public ServiceContractRepository(List<ServiceContract> dbSet) {
        super(dbSet);
    }

    public List<ServiceContractRequest> getInclude() {
        List<ServiceContract> serviceContracts = get();
        List<ServiceContractRequest> personRequestList = null;
        personRequestList = loadRelations(serviceContracts);
        return personRequestList;
    }

    public ServiceContractRequest getInclude(int id) {
        List<ServiceContract> serviceContracts = new Vector<>();
        serviceContracts.add(findById(id));
        ServiceContractRequest serviceContractRequest = null;
        List results = loadRelations(serviceContracts);
        if (results != null && results.size() > 0) {
            serviceContractRequest = loadRelations(serviceContracts).get(0);
            return serviceContractRequest;
        } else {
            return null;
        }
    }

    private List<ServiceContractRequest> loadRelations(List<ServiceContract> contracts) {
        List<ServiceContractRequest> serviceContractRequestList = new Vector<>();
        for (ServiceContract contract :
                contracts) {
            ServiceContractRequest serviceContractRequest = new ServiceContractRequest();
            // Установить ключ
            serviceContractRequest.contractData = contract;

            //Загрузить клиента
            serviceContractRequest.ClientID = contract.ClientID;

            //Загрузить название и цену
            serviceContractRequest.Name = null;
            Service serviceData = null;
            List<Service> services = IOC.ServicesRepository.get(service -> service.Key == contract.ServiceID);
            if (services != null && services.size() > 0)
                serviceData = services.get(0);

            if (serviceData != null) {
                serviceContractRequest.Name = serviceData.Name;
                serviceContractRequest.Price = serviceData.Price;
            }

            //Загрузить рабочих
            serviceContractRequest.WorkerIDs = new Vector<>();

            List<EmployeeGroup> employeeGroups =
                    IOC.EmployeeGroupsRepository.get(e -> e.ServiceContractID == contract.Key);

            for (EmployeeGroup employee :
                    employeeGroups) {
                serviceContractRequest.WorkerIDs.add(employee.EmployeeID);
            }
            serviceContractRequestList.add(serviceContractRequest);
        }
        return serviceContractRequestList;
    }

    //  TODO: load one relation and use in loadRelations to prevent overload in getInclude(id);
}
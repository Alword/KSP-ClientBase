package com.company.Client.Services;

import com.company.Client.Forms.MainWindow;
import com.company.Common.Models.Requests.ServiceContractRequest;
import com.company.ServerApi.Controllers.RequestController.ContractRequestController;

import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class ContractServices {
    private MainWindow window = null;

    private ContractRequestController contractRequestController = null;

    public ContractServices(MainWindow mainWindow) {
        window = mainWindow;
        contractRequestController = new ContractRequestController(window.getConnection());
    }

    public void addContractClick() {
        ServiceContractRequest contractRequest = new ServiceContractRequest();

        // Установить название
        contractRequest.Name = window.contractNameText.getText();

        // Установить цену
        String priceString = window.contractPriceText.getText();
        Double price = Double.parseDouble(priceString);
        contractRequest.Price = price;

        // Установить клиента
        String clientIDString = window.clientIDText.getText();
        Integer clientID = Integer.parseInt(clientIDString);
        contractRequest.ClientID = clientID;

        // Установить рабочих
        String workersIDsString = window.workersIDText.getText();
        String[] workerIDsStringArray = workersIDsString.split(";");
        Vector<Integer> workerIDs = new Vector<>();
        for (String workerIDString :
                workerIDsStringArray) {
            Integer workerID = Integer.parseInt(workerIDString);
            workerIDs.add(workerID);
        }
        contractRequest.WorkerIDs = workerIDs;
        contractRequest.contractData = null;
        addContract(contractRequest);
    }

    public void addContract(ServiceContractRequest serviceContractRequest) {
        contractRequestController.create(serviceContractRequest);
    }

    public void refreshContracts() {
        List<ServiceContractRequest> serviceContractRequests = contractRequestController.getAll();
        DefaultTableModel contractsTableModel = new DefaultTableModel();

        contractsTableModel.addColumn("id");
        contractsTableModel.addColumn("Название");
        contractsTableModel.addColumn("Цена");
        contractsTableModel.addColumn("Клиент");
        contractsTableModel.addColumn("Рабочие");
        contractsTableModel.addColumn("Время");

        for (ServiceContractRequest serviceContractRequest :
                serviceContractRequests) {
            Vector<String> stringVector = new Vector<>();

            //Добавить id;
            stringVector.add(((Integer) serviceContractRequest.contractData.Key).toString());

            //Добавить название
            stringVector.add(serviceContractRequest.Name);

            //Добавить цену
            String priceString = serviceContractRequest.Price.toString();
            stringVector.add(priceString);
            //Добавить клиента
            String clientIDString = serviceContractRequest.ClientID.toString();
            stringVector.add(clientIDString);

            //Добавить рабочих
            String workers = "";
            for (Integer workerId :
                    serviceContractRequest.WorkerIDs) {
                workers += workerId + ";";
            }
            stringVector.add(workers);

            //Добавить Время
            long milliSeconds = serviceContractRequest.contractData.TimeStamp;
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
            Date resultDate = new Date(milliSeconds);
            String contractDataString = sdf.format(resultDate);
            stringVector.add(contractDataString);

            contractsTableModel.addRow(stringVector);
        }
        window.contractJTable.setModel(contractsTableModel);
    }
}
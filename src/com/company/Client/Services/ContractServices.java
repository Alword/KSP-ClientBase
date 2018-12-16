package com.company.Client.Services;

import com.company.Client.Forms.MainWindow;
import com.company.Common.Models.Requests.ContractRequest;
import com.company.Common.Models.Requests.ServiceContractRequest;
import com.company.ServerApi.Controllers.RequestController.ContractRequestController;

import java.util.Vector;

public class ContractServices {
    private MainWindow window = null;

    private ContractRequestController contractRequestController = null;

    public ContractServices(MainWindow mainWindow) {
        window = mainWindow;
        contractRequestController = new ContractRequestController(window.getConnection());
    }

    public void addContractClick() {
        ContractRequest contractRequest = new ContractRequest();

        // Установить название
        contractRequest.Name = window.ContractNameLabel.getText();

        // Установить цену
        String priceString = window.contractPriceLabel.getText();
        Double price = Double.parseDouble(priceString);
        contractRequest.Price = price;

        // Установить клиента
        String clientIDString = window.clientIDLabel.getText();
        Integer clientID = Integer.parseInt(clientIDString);
        contractRequest.ClientID = clientID;

        // Установить рабочих
        String workersIDsString = window.workersIDLabel.getText();
        String[] workerIDsStringArray = workersIDsString.split(";");
        Vector<Integer> workerIDs = new Vector<>();
        for (String workerIDString:
             workerIDsStringArray) {
            Integer workerID = Integer.parseInt(workerIDString);
            workerIDs.add(workerID);
        }
        contractRequest.WorkerIDs = workerIDs;
    }

    public void addContract(ServiceContractRequest serviceContractRequest) {
        contractRequestController.create(serviceContractRequest);
    }

    public void refreshClients() {
        //List<Client> clients = contractRequestController.getAll();
        /* DefaultTableModel clientsTableModel = new DefaultTableModel();
        clientsTableModel.addColumn("id");
        clientsTableModel.addColumn("Название");
        for (Client client :
                clients) {
            Vector<String> stringVector = new Vector<>();
            stringVector.add(((Integer) client.Key).toString());
            stringVector.add(client.OrganizationName);
            clientsTableModel.addRow(stringVector);
        }
        window.clientsJTable.setModel(clientsTableModel);*/
    }
}
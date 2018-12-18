package com.company.Client.Services;

import com.company.Client.Forms.MainWindow;
import com.company.Common.Models.Domains.Employee;
import com.company.Common.Models.Requests.ServiceContractRequest;
import com.company.ServerApi.Controllers.RequestController.ContractRequestController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class ContractServices {
    private MainWindow window = null;

    private List<ServiceContractRequest> serviceContractRequests = null;

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
        if (priceString == "") {
            contractRequest.Price = 0d;
        } else {
            Double price = Double.parseDouble(priceString);
            contractRequest.Price = price;
        }

        // Установить клиента
        contractRequest.ClientID = getInteger(window.clientIDText);

        // Установить рабочих
        contractRequest.WorkerIDs = getWorkerIDs(window.workersIDText);
        contractRequest.contractData = null;
        addContract(contractRequest);
    }

    public void addContract(ServiceContractRequest serviceContractRequest) {
        contractRequestController.create(serviceContractRequest);
    }

    public void refreshContracts() {
        serviceContractRequests = contractRequestController.getAll();
        fillTable(serviceContractRequests, window.contractJTable);
    }

    public void filter() {

        List<ServiceContractRequest> filtered = serviceContractRequests;

        //Проверить клиента
        filtered = filterClientID(filtered);
        //Проверить рабочих
        filtered = filterWorkersID(filtered);
        //Проверить время
        filtered = filterTime(filtered);

        fillTable(filtered, window.filterTable);
    }

    private List<ServiceContractRequest> filterClientID(List<ServiceContractRequest> list) {
        Integer clientID = getInteger(window.filterClientText);
        if (clientID == 0) {
            return list;
        } else {
            list = list.stream().filter(s -> s.ClientID == clientID).collect(Collectors.toList());
            return list;
        }
    }

    private List<ServiceContractRequest> filterWorkersID(List<ServiceContractRequest> list) {
        List<Integer> workerIDs = getWorkerIDs(window.filterWorkersText);
        list = list.stream().filter(s -> s.WorkerIDs.containsAll(workerIDs)).collect(Collectors.toList());
        return list;
    }

    private List<ServiceContractRequest> filterTime(List<ServiceContractRequest> list) {
        //check time
        return list;
    }

    private void fillTable(List<ServiceContractRequest> requests, JTable table) {
        DefaultTableModel contractsTableModel = new DefaultTableModel();

        contractsTableModel.addColumn("id");
        contractsTableModel.addColumn("Название");
        contractsTableModel.addColumn("Цена");
        contractsTableModel.addColumn("Клиент");
        contractsTableModel.addColumn("Рабочие");
        contractsTableModel.addColumn("Время");

        for (ServiceContractRequest serviceContractRequest :
                requests) {
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
        table.setModel(contractsTableModel);
    }

    private boolean isNull(String string) {
        return (string == null || string.equals(""));
    }

    private Integer getInteger(JTextField field) {
        String clientIDString = field.getText();

        if (isNull(clientIDString))
            return 0;

        return Integer.parseInt(clientIDString);
    }

    private List<Integer> getWorkerIDs(JTextField field) {
        // TODO: it's can be single method like getArray<T>;
        // actually too many thinks to do
        // but it's just works
        String workersIDsString = field.getText();
        String[] workerIDsStringArray = workersIDsString.split(";");
        Vector<Integer> workerIDs = new Vector<>();
        for (String workerIDString : workerIDsStringArray) {
            if (isNull(workerIDString))
                continue;

            Integer workerID = Integer.parseInt(workerIDString);
            workerIDs.add(workerID);
        }
        return workerIDs;
    }
}
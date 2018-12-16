package com.company.Client.Services;

import com.company.Client.Forms.MainWindow;
import com.company.Common.Models.Domains.Client;
import com.company.Common.Models.Domains.Employee;
import com.company.Common.Models.Requests.ContractRequest;
import com.company.ServerApi.Controllers.DirectController.ClientDirectController;
import com.company.ServerApi.Controllers.DirectController.EmployeeDirectController;
import com.company.ServerApi.Controllers.RequestController.ContractRequestController;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

public class ContractServices {
    private MainWindow window = null;

    private ContractRequestController contractRequestController = null;

    public ContractServices(MainWindow mainWindow) {
        window = mainWindow;
        contractRequestController = new ContractRequestController(window.getConnection());
    }

    public void addEmployee(int personID) {

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
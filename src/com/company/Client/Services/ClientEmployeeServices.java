package com.company.Client.Services;

import com.company.Client.Forms.MainWindow;
import com.company.Common.Models.Domains.*;
import com.company.Common.Models.Requests.PersonRequest;
import com.company.ServerApi.Controllers.DirectController.ClientDirectController;
import com.company.ServerApi.Controllers.DirectController.EmployeeDirectController;
import com.company.ServerApi.Controllers.RequestController.PersonRequestController;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ClientEmployeeServices {
    private MainWindow window = null;

    private EmployeeDirectController employeeDirectController = null;
    private ClientDirectController clientController = null;


    public ClientEmployeeServices(MainWindow mainWindow) {
        window = mainWindow;
        employeeDirectController = new EmployeeDirectController(window.getConnection());
        clientController = new ClientDirectController(window.getConnection());
    }

    public void addEmployee(int personID) {
        Employee employee = new Employee();
        employee.PersonID = personID;
        employeeDirectController.create(employee);
    }

    public void addClient(String organizationName) {
        Client client = new Client();
        client.OrganizationName = organizationName;
        clientController.create(client);
    }

    public void refreshEmployees() {

    }

    public void refreshClients() {
        List<Client> clients = clientController.getAll();
        DefaultTableModel clientsTableModel = new DefaultTableModel();
        clientsTableModel.addColumn("id");
        clientsTableModel.addColumn("Название");
        for (Client client :
                clients) {
            Vector<String> stringVector = new Vector<>();
            stringVector.add(((Integer) client.Key).toString());
            stringVector.add(client.OrganizationName);
            clientsTableModel.addRow(stringVector);
        }
        window.clientsJTable.setModel(clientsTableModel);
    }
}
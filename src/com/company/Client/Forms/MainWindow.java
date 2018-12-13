package com.company.Client.Forms;

import com.company.Client.Actions.*;
import com.company.Client.Services.PersonRequestServices;
import com.company.ServerApi.Models.Connection;

import javax.swing.*;
import java.io.IOException;

public class MainWindow {

    public JButton buttonMsg;
    public JPanel panelMain;
    public JTabbedPane tabbedPanePerson;
    public JTextField lastNameJTextFiled;
    public JLabel PersonID;
    public JPanel PanelPerson;
    public JLabel keyLabel;
    public JTextField addressesJTextField;
    public JTextField emailsJTextField;
    public JTextField phonesJTextField;
    public JTextField middleNameJTextFiled;
    public JTextField firstNameJTextFiled;
    public JTable personTable;
    JButton addJButton;
    private JButton deletePersonJButton;
    private JButton addClientButton;
    private JButton addEmployeeButton;

    private Connection connection = null;

    public MainWindow() throws InterruptedException {
        connectToServer();
        PersonRequestServices personRequestServices = null;
        personRequestServices = new PersonRequestServices(this);
        addJButton.addMouseListener(new UpdatePersonClickAction(personRequestServices));
        buttonMsg.addMouseListener(new UpdateFromClickAction(personRequestServices));
        personTable.addMouseListener(new SetPersonClickAction(personRequestServices));
        deletePersonJButton.addMouseListener(new DeletePersonClickAction(personRequestServices));
        personRequestServices.updateTable();
        addClientButton.addMouseListener(new AddClientClickAction(personRequestServices));
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public Connection getConnection() {
        return connection;
    }

    private void connectToServer() throws InterruptedException {
        boolean isDisconnected = true;
        do {
            try {
                // Попытка подключения к серверу
                connection = new Connection();
                isDisconnected = false;
            } catch (IOException ex) {
                System.out.println("Сервер недоступен");
                // Ожидание, если сервер недоступен
                Thread x = new Thread();
                Thread.sleep(2000);
            }
        } while (isDisconnected);
    }
}

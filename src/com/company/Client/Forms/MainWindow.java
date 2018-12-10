package com.company.Client.Forms;

import com.company.Client.Actions.UpdatePersonClickAction;
import com.company.Client.Services.PersonRequestServices;
import com.company.Common.Models.Domains.*;
import com.company.Common.Models.Requests.PersonRequest;
import com.company.ServerApi.Controllers.RequestController.PersonRequestController;
import com.company.ServerApi.Models.Connection;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

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
    JButton addJButton;

    private Connection connection = null;

    public MainWindow() throws InterruptedException {
        connectToServer();
        PersonRequestServices personRequestServices = null;
        personRequestServices = new PersonRequestServices(this);
        addJButton.addMouseListener(new UpdatePersonClickAction(personRequestServices));
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
                connection = new Connection();
                isDisconnected = false;
            } catch (IOException ex) {
                System.out.println("Сервер недоступен");
                Thread x = new Thread();
                Thread.sleep(2000);
            }
        } while (isDisconnected);
    }

}

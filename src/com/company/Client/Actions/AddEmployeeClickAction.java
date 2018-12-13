package com.company.Client.Actions;

import com.company.Client.Services.ClientEmployeeServices;
import com.company.Server.Commands.RequestCommands.AddPersonRequestCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddEmployeeClickAction extends AddClientClickAction {

    public AddEmployeeClickAction(ClientEmployeeServices services) {
        super(services);
    }

    @Override
    protected void addPersonClick() {
        message = textField.getText();
        prompterFrame.dispose();
        ceServices.addEmployee(Integer.parseInt(message));
        //ceServices.refreshEmployee();
    }
}

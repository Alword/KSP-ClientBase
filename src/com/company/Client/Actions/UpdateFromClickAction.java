package com.company.Client.Actions;

import com.company.Client.Services.ClientEmployeeServices;
import com.company.Client.Services.PersonRequestServices;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateFromClickAction extends MouseAdapter {

    PersonRequestServices personRequestServices = null;
    ClientEmployeeServices ceServices = null;

    public UpdateFromClickAction(PersonRequestServices services, ClientEmployeeServices ceServices) {
        personRequestServices = services;
        this.ceServices = ceServices;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        personRequestServices.updateTable();
        ceServices.refreshClients();
        ceServices.refreshEmployees();
    }
}

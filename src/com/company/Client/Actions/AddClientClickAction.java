package com.company.Client.Actions;

import com.company.Client.Services.PersonRequestServices;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddClientClickAction extends MouseAdapter {

    PersonRequestServices personRequestServices = null;

    public AddClientClickAction(PersonRequestServices services) {
        personRequestServices = services;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        personRequestServices.removeCurrent();
        personRequestServices.updateTable();
    }
}

package com.company.Client.Actions;

import com.company.Client.Services.PersonRequestServices;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeletePersonClickAction extends MouseAdapter {

    PersonRequestServices personRequestServices = null;

    public DeletePersonClickAction(PersonRequestServices services) {
        personRequestServices = services;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        personRequestServices.removeCurrent();
        personRequestServices.updateTable();
    }
}

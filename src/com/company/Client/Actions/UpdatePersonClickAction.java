package com.company.Client.Actions;

import com.company.Client.Services.PersonRequestServices;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdatePersonClickAction extends MouseAdapter {

    PersonRequestServices personRequestServices = null;
    public UpdatePersonClickAction(PersonRequestServices services)
    {
        personRequestServices = services;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        personRequestServices.send();
        personRequestServices.updateTable();
    }
}

package com.company.Client.Actions;

import com.company.Client.Services.ClientEmployeeServices;
import com.company.Client.Services.ContractServices;
import com.company.Client.Services.PersonRequestServices;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateFromClickAction extends MouseAdapter {

    PersonRequestServices personRequestServices = null;
    ClientEmployeeServices ceServices = null;
    ContractServices cServices = null;

    public UpdateFromClickAction(PersonRequestServices services,
                                 ClientEmployeeServices ceServices,
                                 ContractServices cServices) {
        this.personRequestServices = services;
        this.ceServices = ceServices;
        this.cServices = cServices;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        personRequestServices.updateTable();
        ceServices.refreshClients();
        ceServices.refreshEmployees();
        cServices.refreshContracts();
    }
}

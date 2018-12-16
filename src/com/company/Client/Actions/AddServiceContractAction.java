package com.company.Client.Actions;

import com.company.Client.Services.ContractServices;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddServiceContractAction extends MouseAdapter {

    ContractServices cServices = null;

    public AddServiceContractAction(ContractServices services) {
        cServices = services;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        addServiceContractClick();
    }

    protected void addServiceContractClick() {
        cServices.addContractClick();
        cServices.refreshContracts();
    }
}

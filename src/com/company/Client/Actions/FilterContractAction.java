package com.company.Client.Actions;

import com.company.Client.Services.ContractServices;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FilterContractAction extends MouseAdapter {

    ContractServices cServices = null;

    public FilterContractAction(ContractServices services) {
        cServices = services;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        cServices.filter();
    }
}

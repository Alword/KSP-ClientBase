package com.company.Client.Actions;

import com.company.Client.Services.FilterContractServices;
import com.company.Client.Services.PersonRequestServices;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FilterContractAction extends MouseAdapter {

    FilterContractServices filterContractServices = null;

    public FilterContractAction(FilterContractServices services) {
        filterContractServices = services;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        filterContractServices.filter();
    }
}

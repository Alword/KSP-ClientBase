package com.company.Client.Services;

import com.company.Client.Forms.MainWindow;
import com.company.Common.Models.Domains.Client;
import com.company.Common.Models.Domains.Employee;
import com.company.ServerApi.Controllers.DirectController.ClientDirectController;
import com.company.ServerApi.Controllers.DirectController.EmployeeDirectController;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

public class FilterContractServices {

    private MainWindow window = null;

    public FilterContractServices(MainWindow mainWindow) {
        window = mainWindow;
    }


    public void filter() {
        //TODO: сделать поиск
    }
}
package com.company.Client.Actions;

import com.company.Client.Services.ClientEmployeeServices;
import com.company.Client.Services.PersonRequestServices;

import javax.swing.*;
import javax.swing.text.TextAction;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddClientClickAction extends MouseAdapter {

    ClientEmployeeServices ceServices = null;
    JTextField textField = null;
    JFrame prompterFrame = null;
    String message = "";

    public AddClientClickAction(ClientEmployeeServices services) {
        ceServices = services;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        prompterFrame = new JFrame("Текстовый диалог");
        JPanel panel = new JPanel();

        textField = new JFormattedTextField();
        textField.setSize(200, 200);
        textField.setPreferredSize(new Dimension(200, 20));
        panel.add(textField);

        JButton but1 = new JButton("Add");
        but1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addPersonClick();
            }
        });
        but1.setText("Добавить");
        but1.setMargin(new Insets(0, 0, 0, 0));
        panel.add(but1);

        prompterFrame.add(panel);
        prompterFrame.pack();
        prompterFrame.setLocation(400, 400);
        prompterFrame.setSize(200, 200);
        prompterFrame.setVisible(true);

    }

    protected String getText() {
        return message;
    }

    protected void addPersonClick() {
        //Получить название организации
        message = textField.getText();
        //Закрыть окно
        prompterFrame.dispose();
        //Добавить компанию
        ceServices.addClient(message);
        ceServices.refreshClients();
    }
}

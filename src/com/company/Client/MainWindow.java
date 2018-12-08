package com.company.Client;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow {

    private JButton buttonMsg;
    private JPanel panelMain;
    private JTabbedPane tabbedPanePerson;
    private JTextField textField1;
    private JLabel PersonID;
    private JPanel PanelPerson;

    public MainWindow() {
        buttonMsg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                buttonMsg.setText("Работает");
            }
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

package com.company.Client;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new MainWindow().getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setLocation(300, 300);
        frame.setVisible(true);
    }
}
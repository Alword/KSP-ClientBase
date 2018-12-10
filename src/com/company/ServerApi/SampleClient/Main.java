package com.company.ServerApi.SampleClient;

import com.company.ServerApi.Models.Connection;
import com.company.ServerApi.SampleClient.Tests.TestCommands;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static Connection connection = null;

    public static void main(String[] args) throws IOException {

        try {
            connection = new Connection();
            TestCommands.AddPersonTest(connection);
            TestCommands.AddEmployee(connection);
            TestCommands.AddPersonRequest(connection);
            TestCommands.GetPersonRequest(connection);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                while (input.hasNext()) {
                    String rawData = input.nextLine();
                    connection.sendMsg(rawData);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String AddEmployee() {
        return "";
    }
}

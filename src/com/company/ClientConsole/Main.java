package com.company.ClientConsole;

import com.company.Models.Domains.Email;
import com.company.Models.Domains.Person;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9876);
        Scanner socketScanner = new Scanner(socket.getInputStream());

        try {
            TestCommands.AddPersonTest(socket);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        DataListener dataListener = new DataListener(socketScanner);
        Thread ListenerThread = new Thread(dataListener);
        ListenerThread.start();
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                while (input.hasNext()) {
                    String rawData = input.nextLine();
                    PrintStream socketSender = new PrintStream(socket.getOutputStream());
                    socketSender.println(rawData);
                    socketSender.flush();
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

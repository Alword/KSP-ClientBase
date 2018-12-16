package com.company.Server.Network;

import com.company.Server.Commands.ServerCommand;
import com.company.Server.IOC;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketListener implements Runnable {

    private Socket socket;
    private ServerHub hub;

    public SocketListener(Socket s, ServerHub hub) {
        socket = s;
    }

    public void run() {
        try {
            Scanner input = new Scanner(socket.getInputStream());
            while (input.hasNext()) {
                String cmd = input.nextLine();
                System.out.println(cmd);//logging
                String answer = ServerCommand.invokeCommands(cmd);
                PrintWriter output = new PrintWriter(socket.getOutputStream());
                output.println(answer);
                output.flush();

            }
        } catch (Exception e) {
            hub.Connections.remove(socket);
        } finally {
            IOC.FileManager.SaveContext();
            System.out.println(socket.toString() + " Stopped");
        }
    }
}
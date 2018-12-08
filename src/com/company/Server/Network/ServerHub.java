package com.company.Server.Network;

import com.company.Server.Models.Mapping;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class ServerHub implements Runnable {

    public List<Socket> Connections = null;
    private int tcp = 0;

    public ServerHub(int TCP_port) {
        this.tcp = TCP_port;
        this.Connections = new Vector<Socket>();
    }

    private void listenPorts() throws IOException {
        ServerSocket ss = new ServerSocket(tcp);
        // Ждет клиентов и для каждого создает отдельный поток
        while (true) {
            Socket s = ss.accept();
            Connections.add(s);
            Thread socketListener = new Thread(new SocketListener(s, this));
            socketListener.start();
        }
    }

    @Override
    public void run() {
        System.out.println("The Server Is Running");
        try {
            listenPorts();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Server down: 500");
        }

    }
}
package com.company.Server;

import com.company.Server.Models.Mapping;
import com.company.Server.Network.ServerHub;

public class Main {

    public static void main(String[] args) {
        new IOC();
        new Mapping();
        new ServerHub(9876).run();
    }
}

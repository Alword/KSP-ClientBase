package com.company.Server.Controllers;

import com.company.Server.Commands.ServerCommand;

import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class HomeController extends Controller {
    public List<Socket> sockets = null;

    public HomeController() {
        sockets = new Vector<Socket>();
    }

    public void Start() {

    }

    public void Stop() {

    }
}

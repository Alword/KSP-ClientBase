package com.company.ServerApi.Models;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connection {

    private Socket socket;
    private Scanner scanner = null;
    private PrintWriter writer = null;

    public Connection() throws IOException {
        socket = new Socket("127.0.0.1", 9876);
        scanner = new Scanner(socket.getInputStream());
        writer = new PrintWriter(socket.getOutputStream());
    }

    //Дождаться ответа
    public String getMsg() {
        scanner.hasNext();
        String rawData = scanner.nextLine();
        System.out.println(rawData);
        return rawData;
    }

    // Отправляет сообщение и получает ответ;
    // NOTE: В рамках данной модели
    //       Сервер всегда должен отправить ответ
    //       Например "ОК"
    public String sendMsg(String msg) {
        writer.println(msg);
        writer.flush();
        return getMsg();
    }
}
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
            AddPersonTest(socket);
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

    /////////////////Tests
    public static void AddPersonTest(Socket socket) throws IOException {

        Gson gson = new Gson();
        Person x = new Person();
        x.Key = 0;
        x.FirstName = "Артём";
        x.MiddleName = "Алексеевич";
        x.LastName = "Слепушко";
        String JsonResult = gson.toJson(x);
        System.out.println(JsonResult);

        //Отправляем запрос;
        String request = "AddPersonCommand#" + JsonResult;
        PrintStream socketSender = new PrintStream(socket.getOutputStream());
        socketSender.println(request);
        socketSender.flush();

        //Получаем ответ
        Scanner scanner = new Scanner(socket.getInputStream());
        scanner.hasNext();
        String rawData = scanner.nextLine();
        System.out.println(rawData);
        Person CreatedPerson = gson.fromJson(rawData, Person.class);

        //Добавляем email;
        Email email = new Email();
        email.PersonID = CreatedPerson.Key;
        email.Email = "anzer987@yandex.ru";
        JsonResult = gson.toJson(email);

        //Отправляем запрос;
        request = "AddEmailCommand#" + JsonResult;
        socketSender = new PrintStream(socket.getOutputStream());
        socketSender.println(request);
        socketSender.flush();

        //Получаем ответ
        scanner = new Scanner(socket.getInputStream());
        scanner.hasNext();
        rawData = scanner.nextLine();
        System.out.println(rawData);
        Email CreatedEmail = gson.fromJson(rawData, Email.class);;
    }

    public static String AddEmployee() {
        return "";
    }
}

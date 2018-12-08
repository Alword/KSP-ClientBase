package com.company.ClientConsole;

import com.company.Models.Domains.Email;
import com.company.Models.Domains.Person;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TestCommands {

    public static void AddPersonTest(Socket socket) throws IOException {
        System.out.println("Добавление персональных данных");
        Scanner scanner = new Scanner(socket.getInputStream());
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
        scanner.hasNext();
        String rawData = scanner.nextLine();
        System.out.println(rawData);
        Person CreatedPerson = gson.fromJson(rawData, Person.class);
        System.out.println("Персональные данные получены;");

        System.out.println();
        System.out.println("Добавляем email;");
        //Добавляем email;
        Email email = new Email();
        email.PersonID = CreatedPerson.Key;
        email.Email = "anzer987@yandex.ru";
        JsonResult = gson.toJson(email);

        //Отправляем запрос;
        request = "AddEmailCommand#" + JsonResult;
        socketSender.println(request);
        socketSender.flush();

        //Получаем ответ
        scanner.hasNext();
        rawData = scanner.nextLine();
        System.out.println(rawData);
        Email CreatedEmail = gson.fromJson(rawData, Email.class);;
        System.out.println("Персональные email данные получены;");
    }
}

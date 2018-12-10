package com.company.ServerApi.SampleClient.Tests;

import com.company.Common.Models.Domains.*;
import com.company.Common.Models.Requests.PersonRequest;
import com.company.ServerApi.Controllers.DirectController.EmployeeDirectController;
import com.company.ServerApi.Controllers.RequestController.PersonRequestController;
import com.company.ServerApi.Models.Connection;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class TestCommands {

    public static void AddPersonTest(Connection connection) throws IOException {
        System.out.println("Добавление персональных данных");
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
        String rawData = connection.sendMsg(request);
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
        rawData = connection.sendMsg(request);
        Email CreatedEmail = gson.fromJson(rawData, Email.class);
        ;
        System.out.println("Персональные email данные получены;");
    }

    public static void AddEmployee(Connection connection) throws IOException {
        Employee employee = new Employee();
        employee.Key = 0;
        employee.HomeAddress = 0;
        employee.PersonID = 0;
        employee = new EmployeeDirectController(connection).create(employee);
    }

    // Добавить личные данных используя примитивы
    public static void AddPersonRequest(Connection connection) throws IOException {
        PersonRequest personRequest = new PersonRequest();
        personRequest.PersonData = new Person();
        personRequest.PhonesData = new Vector<>();
        personRequest.AddressesData = new Vector<>();
        personRequest.EmailsData = new Vector<>();

        personRequest.PersonData.Key = 0;
        personRequest.PersonData.FirstName = "Тестер";
        personRequest.PersonData.LastName = "Тестер";
        personRequest.PersonData.MiddleName = "Тестер";

        Phone phone1 = new Phone();
        phone1.Key = 0;
        phone1.PersonID = 0;
        phone1.Phone = "+79606192737";
        personRequest.PhonesData.add(phone1);

        Phone phone2 = new Phone();
        phone2.Key = 0;
        phone2.PersonID = 0;
        phone2.Phone = "8800553535";
        personRequest.PhonesData.add(phone2);

        Address address = new Address();
        address.Key = 0;
        address.PersonID = 0;
        address.Address = "Адрес";
        personRequest.AddressesData.add(address);

        Email email = new Email();
        email.Key = 0;
        email.PersonID = 0;
        email.Email = "mail";
        personRequest.EmailsData.add(email);

        PersonRequestController personRequestController =
                new PersonRequestController(connection);
        personRequest = personRequestController.create(personRequest);
    }

    public static void GetPersonRequest(Connection connection) throws IOException {
        PersonRequestController personRequestController
                = new PersonRequestController(connection);
        List<PersonRequest> personRequestList
                = personRequestController.getAll();
        for (PersonRequest personRequest:
             personRequestList) {
            System.out.println(personRequest);
        }
    }
}
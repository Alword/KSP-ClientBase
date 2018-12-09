package com.company.ServerApi.Controllers.RequestController;

import com.company.Common.Models.Domains.Address;
import com.company.Common.Models.Domains.Email;
import com.company.Common.Models.Domains.Person;
import com.company.Common.Models.Domains.Phone;
import com.company.Common.Models.Requests.PersonRequest;
import com.company.ServerApi.Controllers.DirectController.AddressDirectController;
import com.company.ServerApi.Controllers.DirectController.EmailDirectController;
import com.company.ServerApi.Controllers.DirectController.PersonDirectController;
import com.company.ServerApi.Controllers.DirectController.PhoneDirectController;
import com.company.ServerApi.Controllers.ServerApiController;
import com.company.ServerApi.Models.Connection;

import java.util.List;
import java.util.Vector;

public class PersonRequestController extends ServerApiController<PersonRequest, PersonRequest> {

    PersonDirectController personDirectController = null;
    EmailDirectController emailDirectController = null;
    PhoneDirectController phoneDirectController = null;
    AddressDirectController addressDirectController = null;

    public PersonRequestController(Connection connection) {
        super(connection);
        personDirectController = new PersonDirectController(connection);
        emailDirectController = new EmailDirectController(connection);
        phoneDirectController = new PhoneDirectController(connection);
        addressDirectController = new AddressDirectController(connection);
    }

    @Override
    public PersonRequest create(PersonRequest personRequest) {
        // Чтобы отрпавить все данные пользователя
        // Необходимо отправить основные данны
        // А также адреса эмейлы и телефоны
        Person person = personDirectController.create(personRequest.PersonData);
        personRequest.PersonData = person;


        // Отправить emails
        List<Email> emailList = new Vector<Email>();
        for (Email email :
                personRequest.EmailsData) {
            email.PersonID = person.Key;
            Email reqEmail = emailDirectController.create(email);
            emailList.add(reqEmail);
        }
        personRequest.EmailsData = emailList;

        // Отправить phones
        List<Phone> phonesList = new Vector<Phone>();
        for (Phone phone :
                personRequest.PhonesData) {
            phone.PersonID = person.Key;
            Phone reqPhone = phoneDirectController.create(phone);
            phonesList.add(reqPhone);
        }
        personRequest.PhonesData = phonesList;

        //Отправить адресса
        List<Address> addressList = new Vector<>();
        for (Address address :
                personRequest.AddressesData) {
            address.PersonID = person.Key;
            Address reqAddress = addressDirectController.create(address);
            addressList.add(reqAddress);
        }
        personRequest.AddressesData = addressList;

        return personRequest;
    }
}

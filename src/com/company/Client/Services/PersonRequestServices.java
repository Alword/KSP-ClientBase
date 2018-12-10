package com.company.Client.Services;

import com.company.Client.Forms.MainWindow;
import com.company.Common.Models.Domains.Address;
import com.company.Common.Models.Domains.Email;
import com.company.Common.Models.Domains.Person;
import com.company.Common.Models.Domains.Phone;
import com.company.Common.Models.Requests.PersonRequest;
import com.company.ServerApi.Controllers.RequestController.PersonRequestController;

import java.util.List;
import java.util.Vector;

public class PersonRequestServices {
    private MainWindow window = null;
    public PersonRequestServices(MainWindow mainWindow) {
        window = mainWindow;
    }

    public PersonRequest send() {
        PersonRequest personRequest = new PersonRequest();

        Person person = new Person();
        person.MiddleName = window.middleNameJTextFiled.getText();
        person.LastName = window.lastNameJTextFiled.getText();
        person.FirstName = window.firstNameJTextFiled.getText();
        personRequest.PersonData = person;

        String[] emailsStrings = window.emailsJTextField.getText().split(";");
        List<Email> emailList = new Vector<>();
        for (String emailString :
                emailsStrings) {
            Email email = new Email();
            email.Email = emailString;
            emailList.add(email);
        }
        personRequest.EmailsData = emailList;

        String[] phonesString = window.phonesJTextField.getText().split(";");
        List<Phone> phonesList = new Vector<>();
        for (String phoneString :
                phonesString) {
            Phone phone = new Phone();
            phone.Phone = phoneString;
            phonesList.add(phone);
        }
        personRequest.PhonesData = phonesList;

        String[] addressesString = window.addressesJTextField.getText().split(";");
        List<Address> addressList = new Vector<>();
        for (String addressString :
                addressesString) {
            Address address = new Address();
            address.Address = addressString;
            addressList.add(address);
        }
        personRequest.AddressesData = addressList;
        PersonRequestController controller
                = new PersonRequestController(window.getConnection());
        PersonRequest personResult
                = controller.create(personRequest);
        return personRequest;
    }
}

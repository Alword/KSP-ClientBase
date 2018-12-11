package com.company.Client.Services;

import com.company.Client.Forms.MainWindow;
import com.company.Common.Models.Domains.Address;
import com.company.Common.Models.Domains.Email;
import com.company.Common.Models.Domains.Person;
import com.company.Common.Models.Domains.Phone;
import com.company.Common.Models.Requests.PersonRequest;
import com.company.ServerApi.Controllers.RequestController.PersonRequestController;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonRequestServices {
    private MainWindow window = null;
    private PersonRequestController controller = null;

    public PersonRequestServices(MainWindow mainWindow) {
        window = mainWindow;
        controller = new PersonRequestController(window.getConnection());
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
            if (emailString.length() > 0) {
                Email email = new Email();
                email.Email = emailString;
                emailList.add(email);
            }
        }
        personRequest.EmailsData = emailList;

        String[] phonesString = window.phonesJTextField.getText().split(";");
        List<Phone> phonesList = new Vector<>();
        for (String phoneString :
                phonesString) {
            if (phoneString.length() > 0) {
                Phone phone = new Phone();
                phone.Phone = phoneString;
                phonesList.add(phone);
            }
        }
        personRequest.PhonesData = phonesList;

        String[] addressesString = window.addressesJTextField.getText().split(";");
        List<Address> addressList = new Vector<>();
        for (String addressString :
                addressesString) {
            if (addressString.length() > 0) {
                Address address = new Address();
                address.Address = addressString;
                addressList.add(address);
            }
        }
        personRequest.AddressesData = addressList;
        PersonRequestController controller
                = new PersonRequestController(window.getConnection());
        PersonRequest personResult
                = controller.create(personRequest);
        set(personResult);
        return personResult;
    }

    public void set(PersonRequest personRequest) {
        Person person = personRequest.PersonData;
        window.keyLabel.setText(((Integer) person.Key).toString());
        window.middleNameJTextFiled.setText(person.MiddleName);
        window.lastNameJTextFiled.setText(person.LastName);
        window.firstNameJTextFiled.setText(person.FirstName);

        String emailString
                = listToString(personRequest.EmailsData,
                e -> e.Email + ";");
        window.emailsJTextField.setText(emailString);

        String phoneString
                = listToString(personRequest.PhonesData,
                e -> e.Phone + ";");
        window.phonesJTextField.setText(phoneString);

        String addressString
                = listToString(personRequest.AddressesData,
                e -> e.Address + ";");
        window.addressesJTextField.setText(addressString);

    }

    public void setSelected() {
        Integer selected = window.personTable.getSelectedRow();
        TableModel tableModel = window.personTable.getModel();
        Integer key = Integer.parseInt(tableModel.getValueAt(selected, 0).toString());
        PersonRequest personRequest = controller.getByID(key);
        set(personRequest);
    }

    public void removeCurrent() {
        int currentID = Integer.parseInt(window.keyLabel.getText());
        controller.deleteByID(currentID);
        clearForm();
    }

    public void updateTable() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Табельный номер");
        tableModel.addColumn("Фамилия");
        tableModel.addColumn("Имя");
        tableModel.addColumn("Отчество");
        tableModel.addColumn("Email");
        tableModel.addColumn("Адрес");
        tableModel.addColumn("Мобильный");
        List<PersonRequest> personRequests = controller.getAll();
        for (PersonRequest personRequest : personRequests) {
            Vector<String> tableRow = new Vector<>();
            tableRow.add(((Integer) personRequest.PersonData.Key).toString());
            tableRow.add(personRequest.PersonData.LastName);
            tableRow.add(personRequest.PersonData.FirstName);
            tableRow.add(personRequest.PersonData.MiddleName);
            tableRow.add(listToString(personRequest.EmailsData, Email -> Email.Email + ";"));
            tableRow.add(listToString(personRequest.AddressesData, address -> address.Address + ";"));
            tableRow.add(listToString(personRequest.PhonesData, phone -> phone.Phone + ";"));
            tableModel.addRow(tableRow);
        }
        window.personTable.setModel(tableModel);
    }

    private static <T> String listToString(Collection<T> collection, Function<T, String> mapper) {
        String dataString = collection
                .stream()
                .map(mapper)
                .collect(Collectors.joining());

        if (dataString.length() > 1)
            dataString = dataString.substring(0, dataString.length() - 1);
        return dataString;
    }

    private void clearForm() {
        window.keyLabel.setText("");
        window.middleNameJTextFiled.setText("");
        window.lastNameJTextFiled.setText("");
        window.firstNameJTextFiled.setText("");
        window.emailsJTextField.setText("");
        window.phonesJTextField.setText("");
        window.addressesJTextField.setText("");
    }
}
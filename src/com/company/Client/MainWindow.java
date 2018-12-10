package com.company.Client;

import com.company.Common.Models.Domains.Address;
import com.company.Common.Models.Domains.Email;
import com.company.Common.Models.Domains.Person;
import com.company.Common.Models.Domains.Phone;
import com.company.Common.Models.Requests.PersonRequest;
import com.company.ServerApi.Controllers.RequestController.PersonRequestController;
import com.company.ServerApi.Models.Connection;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class MainWindow {

    private JButton buttonMsg;
    private JPanel panelMain;
    private JTabbedPane tabbedPanePerson;
    private JTextField lastNameJTextFiled;
    private JLabel PersonID;
    private JPanel PanelPerson;
    private JLabel keyLabel;
    private JTextField addressesJTextField;
    private JTextField emailsJTextField;
    private JTextField phonesJTextField;
    private JTextField middleNameJTextFiled;
    private JTextField firstNameJTextFiled;
    private JButton addJButton;

    private Connection connection = null;

    public MainWindow() throws InterruptedException {

        boolean isDisconnected = true;
        do {
            try {
                connection = new Connection();
                isDisconnected = false;
            } catch (IOException ex) {
                System.out.println("Сервер недоступен");
                Thread x = new Thread();
                Thread.sleep(2000);
            }
        } while (isDisconnected);

        addJButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PersonRequest personRequest = new PersonRequest();

                Person person = new Person();
                person.MiddleName = middleNameJTextFiled.getText();
                person.LastName = lastNameJTextFiled.getText();
                person.FirstName = firstNameJTextFiled.getText();
                personRequest.PersonData = person;

                String[] emailsStrings = emailsJTextField.getText().split(";");
                List<Email> emailList = new Vector<>();
                for (String emailString :
                        emailsStrings) {
                    Email email = new Email();
                    email.Email = emailString;
                    emailList.add(email);
                }
                personRequest.EmailsData = emailList;

                String[] phonesString = phonesJTextField.getText().split(";");
                List<Phone> phonesList = new Vector<>();
                for (String phoneString :
                        phonesString) {
                    Phone phone = new Phone();
                    phone.Phone = phoneString;
                    phonesList.add(phone);
                }
                personRequest.PhonesData = phonesList;

                String[] addressesString = addressesJTextField.getText().split(";");
                List<Address> addressList = new Vector<>();
                for (String addressString :
                        addressesString) {
                    Address address = new Address();
                    address.Address = addressString;
                    addressList.add(address);
                }
                personRequest.AddressesData = addressList;
                PersonRequestController controller
                        = new PersonRequestController(connection);
                PersonRequest personResult
                        = controller.create(personRequest);
            }
        });
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

package com.company.Common.Models.Repositories;

import com.company.Common.Commons.BaseRepository;
import com.company.Common.Models.Domains.Address;
import com.company.Common.Models.Domains.Email;
import com.company.Common.Models.Domains.Person;
import com.company.Common.Models.Domains.Phone;
import com.company.Common.Models.Requests.PersonRequest;
import com.company.Server.IOC;

import java.util.List;
import java.util.Vector;

public class PersonRepository extends BaseRepository<Person> {
    public PersonRepository(List<Person> dbSet) {
        super(dbSet);
    }

    public PersonRequest create(PersonRequest personRequest) {
        personRequest.PersonData = create(personRequest.PersonData);

        List<Email> emailsList = new Vector<>();
        for (Email email :
                personRequest.EmailsData) {
            email.PersonID = personRequest.PersonData.Key;
            email = IOC.EmailsRepository.create(email);
            emailsList.add(email);
        }
        personRequest.EmailsData = emailsList;

        List<Phone> phonesList = new Vector<>();
        for (Phone phone :
                personRequest.PhonesData) {
            phone.PersonID = personRequest.PersonData.Key;
            phone = IOC.PhonesRepository.create(phone);
            phonesList.add(phone);
        }
        personRequest.PhonesData = phonesList;

        List<Address> addressList = new Vector<>();
        for (Address address :
                personRequest.AddressesData) {
            address.PersonID = personRequest.PersonData.Key;
            address = IOC.AddressesRepository.create(address);
            addressList.add(address);
        }
        personRequest.AddressesData = addressList;

        return personRequest;
    }

    public List<PersonRequest> getInclude() {
        List<Person> personList = get();
        List<PersonRequest> personRequestList = null;
        personRequestList = loadRelations(personList);
        return personRequestList;
    }

    public PersonRequest getInclude(int id) {
        List<Person> personList = new Vector<>();
        personList.add(findById(id));
        PersonRequest personRequest = null;
        List results = loadRelations(personList);
        if (results != null && results.size() > 0) {
            personRequest = loadRelations(personList).get(0);
            return personRequest;
        } else {
            return null;
        }
    }

    private List<PersonRequest> loadRelations(List<Person> personList) {
        List<PersonRequest> personRequestList = new Vector<>();
        for (Person person :
                personList) {
            PersonRequest personRequest = new PersonRequest();
            personRequest.PersonData = person;
            personRequest.EmailsData =
                    IOC.EmailsRepository.get(email -> email.PersonID == person.Key);
            personRequest.AddressesData =
                    IOC.AddressesRepository.get(address -> address.PersonID == person.Key);
            personRequest.PhonesData =
                    IOC.PhonesRepository.get(phone -> phone.PersonID == person.Key);

            personRequestList.add(personRequest);
        }
        return personRequestList;
    }
}
package com.company.Models.Requests;

import com.company.Models.Domains.Address;
import com.company.Models.Domains.Email;
import com.company.Models.Domains.Person;
import com.company.Models.Domains.Phone;

import java.util.List;

public class PersonRequest {
    public Person PersonData;
    public List<Email> EmailsData;
    public List<Phone> PhonesData;
    public List<Address> AddressesData;
}

package com.company.Common.Models.Requests;

import com.company.Common.Models.Domains.Address;
import com.company.Common.Models.Domains.Email;
import com.company.Common.Models.Domains.Person;
import com.company.Common.Models.Domains.Phone;

import java.util.List;

public class PersonRequest {
    public Person PersonData;
    public List<Email> EmailsData;
    public List<Phone> PhonesData;
    public List<Address> AddressesData;
}

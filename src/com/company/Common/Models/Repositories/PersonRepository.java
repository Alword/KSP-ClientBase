package com.company.Common.Models.Repositories;

import com.company.Common.Commons.BaseRepository;
import com.company.Common.Models.Domains.Person;

import java.util.List;

public class PersonRepository extends BaseRepository<Person> {
    public PersonRepository(List<Person> dbSet) {
        super(dbSet);
    }
}

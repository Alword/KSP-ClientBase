package com.company.Models.Repositories;

import com.company.Commons.BaseRepository;
import com.company.Models.Domains.Person;

import java.util.List;

public class PersonRepository extends BaseRepository<Person> {
    public PersonRepository(List<Person> dbSet) {
        super(dbSet);
    }
}

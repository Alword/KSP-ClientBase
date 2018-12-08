package com.company.Models.Repositories;

import com.company.Commons.BaseRepository;
import com.company.Models.Domains.Phone;

import java.util.List;

public class PhoneRepository extends BaseRepository<Phone> {
    public PhoneRepository(List<Phone> dbSet) {
        super(dbSet);
    }
}

package com.company.Common.Models.Repositories;

import com.company.Common.Commons.BaseRepository;
import com.company.Common.Models.Domains.Phone;

import java.util.List;

public class PhoneRepository extends BaseRepository<Phone> {
    public PhoneRepository(List<Phone> dbSet) {
        super(dbSet);
    }
}

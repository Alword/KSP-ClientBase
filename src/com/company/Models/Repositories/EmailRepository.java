package com.company.Models.Repositories;

import com.company.Commons.BaseRepository;
import com.company.Models.Domains.Email;

import java.util.List;

public class EmailRepository extends BaseRepository<Email> {
    public EmailRepository(List<Email> dbSet) {
        super(dbSet);
    }
}

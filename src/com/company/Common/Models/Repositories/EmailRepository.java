package com.company.Common.Models.Repositories;

import com.company.Common.Commons.BaseRepository;
import com.company.Common.Models.Domains.Email;

import java.util.List;

public class EmailRepository extends BaseRepository<Email> {
    public EmailRepository(List<Email> dbSet) {
        super(dbSet);
    }
}

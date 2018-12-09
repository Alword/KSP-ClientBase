package com.company.Common.Models.Repositories;

import com.company.Common.Commons.BaseRepository;
import com.company.Common.Models.Domains.Client;

import java.util.List;

public class ClientRepository extends BaseRepository<Client> {
    public ClientRepository(List<Client> dbSet) {
        super(dbSet);
    }
}

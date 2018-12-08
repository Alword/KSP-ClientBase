package com.company.Models.Repositories;

import com.company.Commons.BaseRepository;
import com.company.Models.Domains.Client;

import java.util.List;

public class ClientRepository extends BaseRepository<Client> {
    public ClientRepository(List<Client> dbSet) {
        super(dbSet);
    }
}

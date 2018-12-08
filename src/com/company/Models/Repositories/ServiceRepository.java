package com.company.Models.Repositories;

import com.company.Commons.BaseRepository;
import com.company.Models.Domains.Service;

import java.util.List;

public class ServiceRepository extends BaseRepository<Service> {
    public ServiceRepository(List<Service> dbSet) {
        super(dbSet);
    }
}

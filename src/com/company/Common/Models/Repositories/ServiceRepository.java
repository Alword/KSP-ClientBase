package com.company.Common.Models.Repositories;

import com.company.Common.Commons.BaseRepository;
import com.company.Common.Models.Domains.Service;

import java.util.List;

public class ServiceRepository extends BaseRepository<Service> {
    public ServiceRepository(List<Service> dbSet) {
        super(dbSet);
    }
}

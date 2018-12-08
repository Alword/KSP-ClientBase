package com.company.Models.Repositories;

import com.company.Commons.BaseRepository;
import com.company.Models.Domains.ServiceContract;

import java.util.List;

public class ServiceContractRepository extends BaseRepository<ServiceContract> {
    public ServiceContractRepository(List<ServiceContract> dbSet) {
        super(dbSet);
    }
}

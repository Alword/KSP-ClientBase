package com.company.Common.Models.Repositories;

import com.company.Common.Commons.BaseRepository;
import com.company.Common.Models.Domains.ServiceContract;

import java.util.List;

public class ServiceContractRepository extends BaseRepository<ServiceContract> {
    public ServiceContractRepository(List<ServiceContract> dbSet) {
        super(dbSet);
    }
}

package com.company.Models.Repositories;

import com.company.Commons.BaseRepository;
import com.company.Models.Domains.OrganizationWorker;

import java.util.List;

public class OrganizationWorkerRepository extends BaseRepository<OrganizationWorker> {
    public OrganizationWorkerRepository(List<OrganizationWorker> dbSet) {
        super(dbSet);
    }
}

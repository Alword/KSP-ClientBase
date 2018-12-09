package com.company.Common.Models.Repositories;

import com.company.Common.Commons.BaseRepository;
import com.company.Common.Models.Domains.OrganizationWorker;

import java.util.List;

public class OrganizationWorkerRepository extends BaseRepository<OrganizationWorker> {
    public OrganizationWorkerRepository(List<OrganizationWorker> dbSet) {
        super(dbSet);
    }
}

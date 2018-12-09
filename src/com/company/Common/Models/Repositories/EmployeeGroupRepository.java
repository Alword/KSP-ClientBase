package com.company.Common.Models.Repositories;

import com.company.Common.Commons.BaseRepository;
import com.company.Common.Models.Domains.EmployeeGroup;

import java.util.List;

public class EmployeeGroupRepository extends BaseRepository<EmployeeGroup> {
    public EmployeeGroupRepository(List<EmployeeGroup> dbSet) {
        super(dbSet);
    }
}

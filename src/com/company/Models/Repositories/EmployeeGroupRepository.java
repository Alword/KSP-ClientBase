package com.company.Models.Repositories;

import com.company.Commons.BaseRepository;
import com.company.Models.Domains.EmployeeGroup;

import java.util.List;

public class EmployeeGroupRepository extends BaseRepository<EmployeeGroup> {
    public EmployeeGroupRepository(List<EmployeeGroup> dbSet) {
        super(dbSet);
    }
}

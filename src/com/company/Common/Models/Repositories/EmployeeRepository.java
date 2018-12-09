package com.company.Common.Models.Repositories;

import com.company.Common.Commons.BaseRepository;
import com.company.Common.Models.Domains.Employee;

import java.util.List;

public class EmployeeRepository extends BaseRepository<Employee> {
    public EmployeeRepository(List<Employee> dbSet) {
        super(dbSet);
    }
}

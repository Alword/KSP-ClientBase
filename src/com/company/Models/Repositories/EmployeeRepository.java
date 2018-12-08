package com.company.Models.Repositories;

import com.company.Commons.BaseRepository;
import com.company.Models.Domains.Employee;

import java.util.List;

public class EmployeeRepository extends BaseRepository<Employee> {
    public EmployeeRepository(List<Employee> dbSet) {
        super(dbSet);
    }
}

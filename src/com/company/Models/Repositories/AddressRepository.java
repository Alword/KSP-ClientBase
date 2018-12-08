package com.company.Models.Repositories;

import com.company.Commons.BaseRepository;
import com.company.Models.Domains.Address;

import java.util.List;

public class AddressRepository extends BaseRepository<Address> {
    public AddressRepository(List<Address> dbSet) {
        super(dbSet);
    }
}
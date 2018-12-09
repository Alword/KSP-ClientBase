package com.company.Common.Models.Repositories;

import com.company.Common.Commons.BaseRepository;
import com.company.Common.Models.Domains.Address;

import java.util.List;

public class AddressRepository extends BaseRepository<Address> {
    public AddressRepository(List<Address> dbSet) {
        super(dbSet);
    }
}
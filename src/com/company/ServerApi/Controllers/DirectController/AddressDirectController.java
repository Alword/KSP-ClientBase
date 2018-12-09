package com.company.ServerApi.Controllers.DirectController;

import com.company.Common.Models.Domains.Address;
import com.company.Common.Models.Domains.Phone;
import com.company.ServerApi.Controllers.ServerApiController;
import com.company.ServerApi.Models.Connection;

public class AddressDirectController extends ServerApiController<Address, Address> {

    public AddressDirectController(Connection connection) {
        super(connection);
    }

    @Override
    public Address create(Address body) {
        String json = gson.toJson(body);
        json = connection.sendMsg("AddAddressCommand#" + json);
        body = gson.fromJson(json, Address.class);
        return body;
    }
}
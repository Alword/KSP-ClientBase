package com.company.ServerApi.Controllers.DirectController;

import com.company.Common.Models.Domains.Email;
import com.company.Common.Models.Domains.Phone;
import com.company.ServerApi.Controllers.ServerApiController;
import com.company.ServerApi.Models.Connection;

public class PhoneDirectController extends ServerApiController<Phone, Phone> {

    public PhoneDirectController(Connection connection) {
        super(connection);
    }

    @Override
    public Phone create(Phone body) {
        String json = gson.toJson(body);
        json = connection.sendMsg("AddPhoneCommand#" + json);
        body = gson.fromJson(json, Phone.class);
        return body;
    }
}
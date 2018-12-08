package com.company.Models.Domains;

import com.company.Commons.DomainObject;

import java.time.ZonedDateTime;

public class ServiceContract extends DomainObject {
    public int ServiceID;
    public int ClientID;
    public ZonedDateTime TimeStamp;
}

package com.company.Common.Models.Domains;

import com.company.Common.Commons.DomainObject;

import java.time.ZonedDateTime;

public class ServiceContract extends DomainObject {
    public int ServiceID;
    public int ClientID;
    public ZonedDateTime TimeStamp;
}

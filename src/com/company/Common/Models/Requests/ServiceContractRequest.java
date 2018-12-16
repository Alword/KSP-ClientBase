package com.company.Common.Models.Requests;

import com.company.Common.Models.Domains.ServiceContract;

import java.net.PortUnreachableException;
import java.util.List;

public class ServiceContractRequest {
    public ServiceContract contractData;
    public String Name;
    public Double Price;
    public Integer ClientID;
    public List<Integer> WorkerIDs;
}

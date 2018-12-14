package com.company.Common.Models.Requests;

import java.net.PortUnreachableException;
import java.util.List;

public class ContractRequest {
    public String Name;
    public Double Price;
    public Integer ClientID;
    public List<Integer> WorkerIDs;
}

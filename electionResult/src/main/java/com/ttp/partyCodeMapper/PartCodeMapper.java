package com.ttp.partyCodeMapper;

import java.util.HashMap;
import java.util.Map;

public class PartCodeMapper {
    Map<String, String> mappings = new HashMap<>();
    public void doMapping()
    {
        this.mappings.put("BJP", "Bhartiya Janta Party");
        this.mappings.put("INC", "Indian National Congress");
        this.mappings.put("BSP", "Bahujan Samaj Party");
        this.mappings.put("CPI", "Communist Party of India");
        this.mappings.put("NCP", "Nationalist Congress Party");
        this.mappings.put("IND", "Independant");
    }

    public Map<String, String> getMappings()
    {
        return this.mappings;
    }

    public String translatePartyCodeInFullName(String partyCode)
    {
        for (Map.Entry<String, String> party:mappings.entrySet())
        {
            if(party.getKey().equalsIgnoreCase(partyCode))
                return party.getValue();
        }
        return null;
    }
}

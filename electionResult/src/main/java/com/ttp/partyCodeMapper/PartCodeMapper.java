package com.ttp.partyCodeMapper;

import java.util.HashMap;
import java.util.Map;

public class PartCodeMapper {
    Map<String, String> mappings = new HashMap<>();
    public PartCodeMapper(Map<String, String> mappings)
    {
        this.mappings=mappings;
    }

    public Map<String, String> getMappings()
    {
        return this.mappings;
    }
}

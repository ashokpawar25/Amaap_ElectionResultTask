package com.ttp.dataSupplier.dataSupplier;

import java.util.Map;

public class DataSupplier
{
    Map<String, Map<String, Integer>> result;
    public DataSupplier(Map<String, Map<String, Integer>> result)
    {
        this.result = result;
    }

    public Map<String, Map<String, Integer>> getResult()
    {
        return this.result;
    }
}

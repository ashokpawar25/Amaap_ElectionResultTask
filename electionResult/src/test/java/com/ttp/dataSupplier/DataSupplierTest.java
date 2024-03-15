package com.ttp.dataSupplier;

import com.ttp.dataSupplier.dataSupplier.DataSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DataSupplierTest
{
    @Test
    void shouldAbleToGetDataFromDataSupplier()
    {
        //Arrange
        Map<String , Map<String ,Integer>> expectedResult = new HashMap<>();
        Map<String, Integer> bangloreResult = new HashMap<>();
        bangloreResult.put("INC", 11014);
        bangloreResult.put("BJP", 17803);
        bangloreResult.put("CPI",4923);
        bangloreResult.put("NCP", 2069);
        expectedResult.put("Banglore", bangloreResult);

        //Act
        DataSupplier dataSupplier = new DataSupplier(expectedResult);
        Map<String, Map<String, Integer>> actualResult = dataSupplier.getResult();

        //Asert
        Assertions.assertEquals(expectedResult,actualResult);
    }
}

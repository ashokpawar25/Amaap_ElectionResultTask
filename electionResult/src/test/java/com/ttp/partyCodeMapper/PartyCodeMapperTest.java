package com.ttp.partyCodeMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class PartyCodeMapperTest {
    @Test
    void shouldAbleToMapPartyCodes() {
        //Arrange
        Map<String, String> expectedMappings = new HashMap<String, String>();
        expectedMappings.put("BJP", "Bhartiya Janta Party");
        expectedMappings.put("INC", "Indian National Congress");
        expectedMappings.put("BSP", "Bahujan Samaj Party");
        expectedMappings.put("CPI", "Communist Party of India");
        expectedMappings.put("NCP", "Nationalist Congress Party");
        expectedMappings.put("IND", "Independant");

        //Act
        PartCodeMapper partCodeMapper = new PartCodeMapper(expectedMappings);
        Map<String, String> actualMappings = partCodeMapper.getMappings();

        //Assert
        Assertions.assertEquals(expectedMappings, actualMappings);
    }
}

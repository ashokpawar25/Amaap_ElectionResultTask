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
        PartCodeMapper partyCodeMapper = new PartCodeMapper();
        partyCodeMapper.doMapping();
        Map<String, String> actualMappings = partyCodeMapper.getMappings();

        //Assert
        Assertions.assertEquals(expectedMappings, actualMappings);
    }


    @Test
    void shouldAbleToTranslatePartyCodeInFullName() {
        PartCodeMapper partCodeMapper = new PartCodeMapper();
        partCodeMapper.doMapping();

        //Assert
        Assertions.assertEquals("Bhartiya Janta Party", partCodeMapper.translatePartyCodeInFullName("BJP"));
        Assertions.assertEquals("Indian National Congress", partCodeMapper.translatePartyCodeInFullName("INC"));
        Assertions.assertEquals("Bahujan Samaj Party", partCodeMapper.translatePartyCodeInFullName("BSP"));
        Assertions.assertEquals("Communist Party of India", partCodeMapper.translatePartyCodeInFullName("CPI"));
        Assertions.assertEquals("Nationalist Congress Party", partCodeMapper.translatePartyCodeInFullName("NCP"));
        Assertions.assertEquals("Independant", partCodeMapper.translatePartyCodeInFullName("IND"));
    }
}

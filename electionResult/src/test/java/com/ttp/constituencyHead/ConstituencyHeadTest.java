package com.ttp.constituencyHead;

import com.ttp.constitencyHead.ConstituencyHead;
import com.ttp.dataSupplier.dataSupplier.DataSupplier;
import com.ttp.partyCodeMapper.PartCodeMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ConstituencyHeadTest {
    @Test
    void shouldAbleToAnalyzeDataAndDeclareWinner() {
        //Arrange
        PartCodeMapper partCodeMapper = new PartCodeMapper();

        Map<String, Map<String, Integer>> result = new HashMap<>();
        Map<String, Integer> bangloreResult = new HashMap<>();
        bangloreResult.put("INC", 11014);
        bangloreResult.put("BJP", 17803);
        bangloreResult.put("CPI", 4923);
        bangloreResult.put("NCP", 2069);
        result.put("Banglore", bangloreResult);
        DataSupplier dataSupplier = new DataSupplier(result);
        Map<String, Map<String, Integer>> expectedWinner = new HashMap<>();
        Map<String, Integer> winnerData = new HashMap<>();
        winnerData.put("BJP", 17803);
        expectedWinner.put("Banglore", winnerData);

        //Act
        ConstituencyHead constituencyHead = new ConstituencyHead(partCodeMapper, dataSupplier);
        Map<String, Map<String, Integer>> actualWinner = constituencyHead.analyzeResult();

        //Assert
        Assertions.assertEquals(expectedWinner, actualWinner);
    }
}

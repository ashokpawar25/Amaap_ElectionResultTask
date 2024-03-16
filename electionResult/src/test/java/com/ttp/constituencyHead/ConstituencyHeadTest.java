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
    void shouldAbleToAnalyzeResultAndDeclareWinnerForSingleConstituency() {
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
        winnerData.put("Bhartiya Janta Party", 17803);
        expectedWinner.put("Banglore", winnerData);
        partCodeMapper.doMapping();

        //Act
        ConstituencyHead constituencyHead = new ConstituencyHead(partCodeMapper, dataSupplier);
        Map<String, Map<String, Integer>> actualWinner = constituencyHead.analyzeResult();


        //Assert
        Assertions.assertEquals(expectedWinner, actualWinner);
    }

    @Test
    void shouldAbleToAnalyzeResultAndDeclareWinnerForMultipleConstituency() {
        //Arrange
        PartCodeMapper partCodeMapper = new PartCodeMapper();

        Map<String, Map<String, Integer>> result = new HashMap<>();

        Map<String, Integer> bangloreResult = new HashMap<>();
        bangloreResult.put("INC", 11014);
        bangloreResult.put("BJP", 17803);
        bangloreResult.put("CPI", 4923);
        bangloreResult.put("NCP", 2069);
        result.put("Banglore", bangloreResult);

        Map<String, Integer> puneResult = new HashMap<>();
        puneResult.put("INC", 9389);
        puneResult.put("CPI", 4829);
        puneResult.put("BJP", 3375);
        puneResult.put("NCP", 3371);
        puneResult.put("BSP", 309);
        puneResult.put("IND", 100);
        result.put("Pune", puneResult);


        DataSupplier dataSupplier = new DataSupplier(result);

        Map<String, Map<String, Integer>> expectedWinner = new HashMap<>();
        Map<String, Integer> bangloreWinnerData = new HashMap<>();
        bangloreWinnerData.put("Bhartiya Janta Party", 17803);
        expectedWinner.put("Banglore", bangloreWinnerData);

        Map<String, Integer> puneWinnerData = new HashMap<>();
        puneWinnerData.put("Indian National Congress", 9389);
        expectedWinner.put("Pune", puneWinnerData);
        partCodeMapper.doMapping();

        //Act
        ConstituencyHead constituencyHead = new ConstituencyHead(partCodeMapper, dataSupplier);
        Map<String, Map<String, Integer>> actualWinner = constituencyHead.analyzeResult();

        //Assert
        Assertions.assertEquals(expectedWinner, actualWinner);


    }
}

package com.ttp.constitencyHead;

import com.ttp.dataSupplier.dataSupplier.DataSupplier;
import com.ttp.partyCodeMapper.PartCodeMapper;

import java.util.HashMap;
import java.util.Map;

public class ConstituencyHead {
    PartCodeMapper partCodeMapper;
    DataSupplier dataSupplier;
    public ConstituencyHead(PartCodeMapper partCodeMapper, DataSupplier dataSupplier)
    {
        this.partCodeMapper=partCodeMapper;
        this.dataSupplier=dataSupplier;
    }

    public Map<String, Map<String, Integer>> analyzeResult()
    {
        Map<String, Map<String, Integer>> result = dataSupplier.getResult();
        Map<String, Map<String, Integer>> constituncyWinner = new HashMap<>();

        for(Map.Entry<String, Map<String, Integer>> constituency:result.entrySet()) {
            Map<String, Integer> winningPartyData = new HashMap<>();
            int winnerPartyVotes = 0;
            String winningPartyName = "";
            for (Map.Entry<String, Integer> entry : constituency.getValue().entrySet()) {

                if (entry.getValue() > winnerPartyVotes) {
                    winnerPartyVotes = entry.getValue();
                    winningPartyName= entry.getKey();
                }
            }
            String winningPartyFullName = partCodeMapper.translatePartyCodeInFullName(winningPartyName);
            winningPartyData.put(winningPartyFullName, winnerPartyVotes);
            constituncyWinner.put( constituency.getKey(), winningPartyData);
        }
        return constituncyWinner;
    }
}

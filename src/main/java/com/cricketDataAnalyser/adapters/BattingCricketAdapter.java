package com.cricketDataAnalyser.adapters;

import com.cricketDataAnalyser.dao.CricketDAO;
import com.cricketDataAnalyser.exceptions.CricketAnalysisException;
import com.cricketDataAnalyser.models.BattingDataCSV;

import java.util.Map;

public class BattingCricketAdapter extends CricketAdapter {
    @Override
    public Map<String, CricketDAO> loadCricketData(String... csvFilePath) throws CricketAnalysisException {
        Map<String, CricketDAO> battingDAOMap = super.loadCricketData(BattingDataCSV.class, csvFilePath[0]);
        return battingDAOMap;
    }
}

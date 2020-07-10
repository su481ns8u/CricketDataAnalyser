package com.cricketDataAnalyser.services;

import com.cricketDataAnalyser.adapters.CricketAdapterFactory;
import com.cricketDataAnalyser.dao.CricketDAO;
import com.cricketDataAnalyser.exceptions.CricketAnalysisException;

import java.util.List;
import java.util.Map;

public class CricketAnalyser {
    public enum PlayOption {
        BAT
    }

    private PlayOption playOption;
    private List<CricketDAO> cricketDAOList;

    public Map<String, CricketDAO> loadCricketData(PlayOption playOption, String... csvFilePath)
            throws CricketAnalysisException {
        this.playOption = playOption;
        Map<String, CricketDAO> cricketDAOMap = new CricketAdapterFactory().getCricketData(playOption, csvFilePath);
        return cricketDAOMap;
    }
}

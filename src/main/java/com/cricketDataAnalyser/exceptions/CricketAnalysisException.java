package com.cricketDataAnalyser.exceptions;

public class CricketAnalysisException extends Throwable {
    public enum ExceptionType {
        FILE_PROBLEM,
        INVALID_HEADER_AND_DELIMITER,
        EMPTY_FILE,
        INVALID_PARAMETER
    }

    public ExceptionType type;

    public CricketAnalysisException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }

    public CricketAnalysisException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}

package com.edumind.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SentimentResult {
    private String sentiment;  //positive / negative / neutral
    private double score;      //-1到1

    public SentimentResult(String sentiment, double score) {
        this.sentiment = sentiment;
        this.score = score;
    }
}

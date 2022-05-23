package com.dorin.task1;

import java.util.HashMap;
import java.util.Map;

public class BirthdayCakeCandles {

    public int birthdayCakeCandles(int[] candles) {
        if(candles == null || candles.length == 0) {
            throw new IllegalArgumentException("candles array must be non-null with at least one item");
        }

        Map<Integer, Integer> dictionary = new HashMap<>();
        int maxCandle = candles[0];

        for(int candle : candles){
            if(candle > maxCandle) {
                maxCandle = candle;
            }

            Integer extractedValue = dictionary.get(candle);
            if(extractedValue == null){
                dictionary.put(candle, 1);
            }else{
                dictionary.put(candle, extractedValue + 1);
            }
        }

        return dictionary.get(maxCandle);
    }

}
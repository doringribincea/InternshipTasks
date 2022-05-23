package com.dorin.task1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        
        List<Integer> items = Arrays.stream(args)
            .map(arg -> Integer.valueOf(arg)).collect(Collectors.toList());

        int[] arr = new int[items.size()];

        int i=0;
        for(var item : items){
            arr[i++] = item;
        }

        BirthdayCakeCandles b = new BirthdayCakeCandles();
        System.out.println(b.birthdayCakeCandles(arr));;
    }
}

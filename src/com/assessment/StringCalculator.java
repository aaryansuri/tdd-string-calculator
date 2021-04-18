package com.assessment;



public class StringCalculator {

    public int Add(String numbers) {

        if(numbers.isEmpty() || numbers.isBlank()) return 0;

        String[] numSplits = numbers.split(",");

        if(numSplits.length==1) return Integer.parseInt(numSplits[0]);

        int num1 = Integer.parseInt(numSplits[0]);
        int num2 = Integer.parseInt(numSplits[1]);

        return num1 + num2;


    }


}

package com.assessment;



public class StringCalculator {

    public int Add(String numbers) {

        if(numbers.isEmpty() || numbers.isBlank()) return 0;

        String[] numSplits = numbers.split("[,\n]\\s*"); //regex for splitting string by comma or
                                                               //new line, and blank spaces if specified in input


        int sum = 0;

        for(String num : numSplits){
            int n = Integer.parseInt(num);
            sum+=n;
        }

        return sum;


    }


}

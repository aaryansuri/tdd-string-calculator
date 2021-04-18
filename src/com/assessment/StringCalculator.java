package com.assessment;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern numbersPattern = Pattern.compile("^(//[;,]\n)(.*)"); // , and ; are two different delimiters for now

    public int Add(String numbers)  {

        if(numbers.isEmpty() || numbers.isBlank()) return 0;

        Matcher matcher = numbersPattern.matcher(numbers);

        if(matcher.find()) {
            numbers = numbers.substring(matcher.start(2)); // ignores the characters before the first numbers
        }

        String[] numSplits = numbers.split("[,;\n]\\s*"); //regex for splitting string by delimiters or
                                                               //new line, and blank spaces if specified in input

        int sum = 0;

        StringBuilder negatives = new StringBuilder();

        for(String num : numSplits){

            int n = Integer.parseInt(num);

            if(n>1000) continue;

            if(n<0) {
                negatives.append(num).append(',');
            }

            sum+=n;
        }

        if(negatives.length()>0) {
            negatives.deleteCharAt(negatives.length()-1); // last , delete
            throw new NegativeNumberException("negatives not allowed -> "+negatives.toString());
        }

        return sum;


    }


}

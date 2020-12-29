package com.seleniumtesting.dobiDemo.basicOperration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class stringManipulation {


    /**
     * String manipulation using REGEX to capture second occurrence of number in given string
     * <p>
     * Example: given String of "Showing 1 to 407 of 407 entries".
     * This method would return String of "407"
     *
     * @param textFromElement given String
     * @return second occurrence of number or "Not Found" if there is no match
     */
    public static String getNumberofEntries(String textFromElement){

        //ignore any non-digit
        //ignore first occurrence of number
        //continue ignore any non-digit
        //capture the second occurrence of number
        Pattern pattern = Pattern.compile("[^\\d]*[\\d]+[^\\d]+([\\d]+)");

        Matcher matcher=pattern.matcher(textFromElement);

        // if an occurrence if a pattern was found in a given string
        if(matcher.find()){
            //second matched number in the given string
            return matcher.group(1);
        }


        return "Not Found";
    }
}

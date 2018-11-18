package io.falcon.assignment.Helper;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PalindromeControllerHelper {

    public boolean isPalindrome(String palindrome){
        // Only alphabetical characters are considered
        if (!palindrome.matches("[a-zA-Z]+")) return false;

        palindrome = palindrome.toLowerCase();

        String[] array = palindrome.split("");
        String[] reversedArray = palindrome.split("");


        // Reverse the values in one of the arrays if the arrays are then identical the word is a palindrome
        for (int i=0; i< reversedArray.length / 2; i++){
            String temp = reversedArray[i];
            reversedArray[i] = reversedArray[reversedArray.length -i -1];
            reversedArray[reversedArray.length -i -1] = temp;
        }

        if (!Arrays.equals(reversedArray, array)) return false;

        return true;
    }

    public int getLongestPalindrome(String text){
        // Don't do the calculation if the entire text is a palindrome in itself
        if (this.isPalindrome(text)) return  text.length();

        List<String> validPalindromes = new ArrayList<>();

        for (int i = 0; i < text.length(); i++){
            // palindrome is used to store every letter that is looped through
            String palindrome = String.valueOf(text.charAt(i));

            char currentLetter = text.charAt(i);

            // The rest of the text is saved so every letter can be compared to the currentLetter
            String restOfText = text.substring(i + 1);

            // Look for a letter matching currentLetter and validate the palindrome
            for (int j = 0; j < restOfText.length(); j++){
                char nextLetter = restOfText.charAt(j);

                if (currentLetter != nextLetter){
                    palindrome += nextLetter;
                }else{
                    palindrome += nextLetter;
                    if (isPalindrome(palindrome)) validPalindromes.add(palindrome);
                }
            }
        }

        int longestPalindrome = 0;
        for (String str: validPalindromes){
            if (longestPalindrome < str.length()) longestPalindrome = str.length();
        }

        return longestPalindrome;
    }
}

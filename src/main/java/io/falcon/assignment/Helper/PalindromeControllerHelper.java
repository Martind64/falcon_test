package io.falcon.assignment.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromeControllerHelper {

    public boolean isPalindrome(String palindrome){
        // Only alphabetical characters are considered
        if (!palindrome.matches("[a-zA-Z]+")) return false;

        palindrome = palindrome.toLowerCase();

        String[] array = palindrome.split("");
        String[] reversedArray = palindrome.split("");


        // Reverse the values in one of the arrays so we are able to check if the word is a palindrome
        for (int i=0; i< reversedArray.length / 2; i++){
            String temp = reversedArray[i];
            reversedArray[i] = reversedArray[reversedArray.length -i -1];
            reversedArray[reversedArray.length -i -1] = temp;
        }

        if (!Arrays.equals(reversedArray, array)) return false;

        return true;
    }

}

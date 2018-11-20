package unittests;

import io.falcon.assignment.helper.PalindromeControllerHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class PalindromeControllerHelperTest {

    private PalindromeControllerHelper palindromeControllerHelper;

    @Before
    public void setUp(){
        this.palindromeControllerHelper = new PalindromeControllerHelper();
    }


    @Test
    public void isPalindrome_validPalindrome_true(){
        boolean result = this.palindromeControllerHelper.isPalindrome("aka");
        assertTrue(result);
    }

    @Test
    public void isPalindrome_invalidPalindrome_true(){
        boolean result = this.palindromeControllerHelper.isPalindrome("kaka");
        assertFalse(result);
    }

    @Test
    public void isPalindrome_stringContaintingNonAlphabeticChars_false(){
        boolean result = this.palindromeControllerHelper.isPalindrome("?aka?");
        assertFalse(result);
    }

    @Test
    public void isPalindrome_stringContainingCapitalizedChars_true(){
        boolean result = this.palindromeControllerHelper.isPalindrome("PalAp");

        assertTrue(result);
    }

    @Test
    public void isPalindrome_stringContainingLessThanFreeLetters_false(){
        boolean result = this.palindromeControllerHelper.isPalindrome("aa");

        assertFalse(result);
    }

    @Test
    public void getLongestPalindrome_palindromeSize6_5(){
        int result = this.palindromeControllerHelper.getLongestPalindrome("apaapa");
        assertEquals(6, result);
    }

    @Test
    public void getLongestPalindrome_stringAbrakadabra_3(){
        int result = this.palindromeControllerHelper.getLongestPalindrome("abrakadabra");
        assertEquals(3, result);
    }

    @Test
    public void getLongestPalindrome_stringContaingSpecialChars_3(){
        int result = this.palindromeControllerHelper.getLongestPalindrome("?aka.a?");
        assertEquals(3, result);
    }

}

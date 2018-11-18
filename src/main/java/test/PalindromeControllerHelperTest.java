package test;

import io.falcon.assignment.Helper.PalindromeControllerHelper;
import io.falcon.assignment.PalindromeController;
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


}

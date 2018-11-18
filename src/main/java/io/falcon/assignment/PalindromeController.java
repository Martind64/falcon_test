package io.falcon.assignment;

import io.falcon.assignment.Entity.Palindrome;
import io.falcon.assignment.Model.ResponsePalindrome;
import io.falcon.assignment.Repository.PalindromeRepository;
import io.vavr.collection.List;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class PalindromeController {

    @Autowired
    PalindromeRepository palindromeRepository;

    @PostMapping("/palindrome")
    public Palindrome create(@RequestBody Palindrome pal) {
        return palindromeRepository.save(pal);
    }

    @GetMapping("/palindrome")
    @ResponseBody
    public List<ResponsePalindrome> getAll(){
        List<Palindrome> palindromes = List.ofAll(palindromeRepository.findAll());


        List<ResponsePalindrome> response = palindromes.map(pal -> {
            ResponsePalindrome responsePal = new ResponsePalindrome();
            responsePal.setContent(pal.getContent());
            responsePal.setTimestamp(pal.getTimestamp());
            responsePal.setLongest_palindrome_size(3);
            return responsePal;
        });

        return response;
    }


}

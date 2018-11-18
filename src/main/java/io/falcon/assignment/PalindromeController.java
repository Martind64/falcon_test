package io.falcon.assignment;

import io.falcon.assignment.Entity.Palindrome;
import io.falcon.assignment.Model.ResponsePalindrome;
import io.falcon.assignment.Repository.PalindromeRepository;
import io.vavr.collection.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    public List<Palindrome> getAll(){
        io.vavr.collection.List<Palindrome> palindromes = io.vavr.collection.List.ofAll(palindromeRepository.findAll());


        return palindromes;
    }

}

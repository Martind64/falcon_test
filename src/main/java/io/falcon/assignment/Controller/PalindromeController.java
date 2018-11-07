package io.falcon.assignment.Controller;

import io.falcon.assignment.Entity.Palindrome;
import io.falcon.assignment.Repository.PalindromeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Component
public class PalindromeController {

    @Autowired
    PalindromeRepository palindromeRepository;

    @PostMapping("/palindrome")
    public Palindrome create(@RequestBody Palindrome pal){
        return palindromeRepository.save(pal);
    }

    @GetMapping("/palindrome")
    public List<Palindrome> getAll(){
        return (List<Palindrome>) palindromeRepository.findAll();
    }
}

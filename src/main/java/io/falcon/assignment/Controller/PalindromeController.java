package io.falcon.assignment.Controller;

import io.falcon.assignment.Entity.Palindrome;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {


    @PostMapping
    public Palindrome create(@RequestBody Palindrome pal){
        return new Palindrome(pal.getId() + 1, pal.getText());
    }
}

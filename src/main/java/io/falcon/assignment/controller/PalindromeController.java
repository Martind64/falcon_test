package io.falcon.assignment.controller;

import io.falcon.assignment.entity.Palindrome;
import io.falcon.assignment.helper.PalindromeControllerHelper;
import io.falcon.assignment.model.ResponsePalindrome;
import io.falcon.assignment.repository.PalindromeRepository;
import io.vavr.collection.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;

@RestController
public class PalindromeController {

    @Autowired
    PalindromeRepository palindromeRepository;

    @Autowired
    PalindromeControllerHelper palindromeControllerHelper;

    @Autowired
    private SimpMessagingTemplate template;

    @PostMapping("/palindrome")
    public Palindrome create(@Valid @RequestBody Palindrome pal) {

        String timestamp  = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ssZ").format(pal.getTimestamp());

        ResponsePalindrome palin = new ResponsePalindrome();
        palin.setContent(pal.getContent());
        palin.setTimestamp(timestamp);
        palin.setLongest_palindrome_size(palindromeControllerHelper.getLongestPalindrome(pal.getContent()));

        this.template.convertAndSend("/topic/palindrome", palin);
        return palindromeRepository.save(pal);
    }

    @GetMapping("/palindrome")
    public List<ResponsePalindrome> getAll(){
        List<Palindrome> palindromes = List.ofAll(palindromeRepository.findAll());

        List<ResponsePalindrome> response = palindromes.map(pal -> {
            // As the timestamp has to be returned ending with +0000 instead of Z we convert the zonedDatetime to a string to show that format
            String timestamp  = DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ssZ").format(pal.getTimestamp());
            Integer longestPalindrome = palindromeControllerHelper.getLongestPalindrome(pal.getContent());

            ResponsePalindrome responsePal = new ResponsePalindrome();
            responsePal.setContent(pal.getContent());
            responsePal.setTimestamp(timestamp);
            responsePal.setLongest_palindrome_size(longestPalindrome);
            return responsePal;
        });

        return response;
    }


}

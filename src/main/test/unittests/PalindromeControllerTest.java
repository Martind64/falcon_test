package unittests;

import io.falcon.assignment.Application;
import io.falcon.assignment.controller.PalindromeController;
import io.falcon.assignment.entity.Palindrome;
import io.falcon.assignment.model.ResponsePalindrome;
import io.falcon.assignment.repository.PalindromeRepository;
import io.vavr.collection.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "../resources/application.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Application.class })
public class PalindromeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private PalindromeRepository palindromeRepository;

    @InjectMocks
    private PalindromeController palindromeController;

    @Test
    public void getAll_methodCalled_returnedListHasLongestPalindrome3() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Iterable<Palindrome> returnedPalindromes = this.getPalindromeList();

        Mockito.when(palindromeRepository.findAll()).thenReturn(returnedPalindromes);

        ResponseEntity<List<ResponsePalindrome>> result = restTemplate.exchange(
                "/palindrome",
                HttpMethod.GET,
                new HttpEntity<>(null, headers),
                new ParameterizedTypeReference<List<ResponsePalindrome>>() {}
        );

        List<ResponsePalindrome> body = result.getBody();

        Integer expected = body.get(0).getLongest_palindrome_size();

        Assert.assertEquals(3, expected.intValue());
    }

    @Test
    public void getAll_methodCalled_returnedListHas2Elements() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Iterable<Palindrome> returnedPalindromes = this.getPalindromeList();

        Mockito.when(palindromeRepository.findAll()).thenReturn(returnedPalindromes);

        ResponseEntity<List<ResponsePalindrome>> result = restTemplate.exchange(
                "/palindrome",
                HttpMethod.GET,
                new HttpEntity<>(null, headers),
                new ParameterizedTypeReference<List<ResponsePalindrome>>() {}
        );

        List<ResponsePalindrome> body = result.getBody();

        Assert.assertEquals(2, body.length());
    }

    private Iterable<Palindrome> getPalindromeList(){
        Palindrome palindrome = new Palindrome();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssZ");
        ZonedDateTime datetime = ZonedDateTime.parse("2018-10-09 19:36:12+0000", formatter);

        palindrome.setId(10);
        palindrome.setContent("abrakadabra");
        palindrome.setTimestamp(datetime);

        return new ArrayList<Palindrome>() {{
            add(palindrome);
            add(palindrome);
        }};
    }
}

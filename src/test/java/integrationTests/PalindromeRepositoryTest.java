package integrationTests;
import static org.junit.Assert.assertEquals;

import io.falcon.assignment.Application;
import io.falcon.assignment.Entity.Palindrome;
import io.falcon.assignment.Repository.PalindromeRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = Application.class)
public class PalindromeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PalindromeRepository palindromeRepository;

}

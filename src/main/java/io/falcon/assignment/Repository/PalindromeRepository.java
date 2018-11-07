package io.falcon.assignment.Repository;

import io.falcon.assignment.Entity.Palindrome;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromeRepository extends CrudRepository<Palindrome, Long> {
}

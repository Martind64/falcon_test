package io.falcon.assignment.Repository;

import io.falcon.assignment.Entity.Palindrome;
import org.springframework.data.repository.CrudRepository;

public interface PalindromeRepository extends CrudRepository<Palindrome, Long> {
}

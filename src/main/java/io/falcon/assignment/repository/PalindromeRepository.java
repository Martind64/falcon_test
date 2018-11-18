package io.falcon.assignment.repository;

import io.falcon.assignment.entity.Palindrome;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromeRepository extends CrudRepository<Palindrome, Long> {
}

package io.falcon.assignment.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Palindrome {

    @Id
    @GeneratedValue
    private final long id;

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Palindrome(long id, String text) {
        this.id = id;
        this.text = text;
    }

    private final String text;

}

package io.falcon.assignment.model;

public class Palindrome {
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

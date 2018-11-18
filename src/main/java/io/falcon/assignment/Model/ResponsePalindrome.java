package io.falcon.assignment.Model;

import java.sql.Timestamp;

public class ResponsePalindrome {

    private String content;

    private Timestamp timestamp;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getLongest_palindrome_size() {
        return longest_palindrome_size;
    }

    public void setLongest_palindrome_size(Integer longest_palindrome_size) {
        this.longest_palindrome_size = longest_palindrome_size;
    }

    private Integer longest_palindrome_size;
}

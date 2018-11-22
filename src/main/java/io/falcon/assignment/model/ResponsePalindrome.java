package io.falcon.assignment.model;

public class ResponsePalindrome {

    private String content;
    private Integer longest_palindrome_size;
    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLongest_palindrome_size() {
        return longest_palindrome_size;
    }

    public void setLongest_palindrome_size(Integer longest_palindrome_size) {
        this.longest_palindrome_size = longest_palindrome_size;
    }

}

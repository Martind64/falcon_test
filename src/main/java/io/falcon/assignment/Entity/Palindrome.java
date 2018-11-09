package io.falcon.assignment.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "test")
public class Palindrome {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    private long id;

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ssZ")
    private Date timestamp;

    public Palindrome() {
    }

    public Palindrome(String content){
        this.content = content;
    }
}

package io.falcon.assignment.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "test")
public class Palindrome {

    @Id
    @GeneratedValue
    private long id;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ssZ")
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

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Palindrome{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public void setId(long id) {
        this.id = id;
    }

    public Palindrome() {
    }

    public Palindrome(String content){
        this.content = content;
    }
}

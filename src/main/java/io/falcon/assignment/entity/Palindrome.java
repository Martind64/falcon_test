package io.falcon.assignment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.vavr.match.annotation.Patterns;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Entity
@Table(name = "test")
public class Palindrome {

    @Id
    @GeneratedValue
    private long id;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd' 'HH:mm:ssZ")
//    @Pattern(regexp = )
    private ZonedDateTime timestamp;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Palindrome(String content, ZonedDateTime timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

    public Palindrome() {
    }

    public Palindrome(String content){
        this.content = content;
    }
}

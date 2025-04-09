package org.example.mailserver.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "mails") // Ensures it maps to the mails table
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "subject")
    private String subject;


    @Column(name = "from_Email")
    private String fromEmail;


    @Column(name = "to_Email")
    private String toEmail;


    @Column(name = "content")
    private String content;

    @Column(name = "timestamp")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;




    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Mail() {
    }

    public Mail(String subject, String fromEmail, String toEmail, String content) {
        this.subject = subject;
        this.fromEmail = fromEmail;
        this.toEmail = toEmail;
        this.content = content;
    }

    @PrePersist
    public void setTimestamp() {
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Mail [id=" + id + ", subject=" + subject + ", fromEmail=" + fromEmail + "]";
    }
}

/*
package org.example.mailserver.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "mails")
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    @Column(name = "subject")
    private String subject;

    @Getter
    @Setter
    @Column(name = "fromEmail")
    private String fromEmail;

    @Getter
    @Setter
    @Column(name = "toEmail")
    private String toEmail;

    @Getter
    @Setter
    @Column(name = "content")
    private String content;

    public Mail() {

    }

    public Mail(String subject, String fromEmail, String toEmail, String content) {
        this.subject = subject;
        this.fromEmail = fromEmail;
        this.toEmail = toEmail;
        this.content = content;
    }


    @Override
    public String toString() {
        return "Mail [id=" + id + ", subject=" + subject + ", fromEmail=" + fromEmail;
    }
}

*/

package com.go4code.server.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;

    private String content;

    private String attachment;

    @ManyToOne
    private Post post;

    private LocalDateTime date;


    public Comment(){

    }

    public Comment(Long id, User user, String content, String attachment,LocalDateTime date, Post post) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.date = date;
        this.attachment = attachment;
        this.post = post;
    }

    public Comment( User user, String content, String attachment, LocalDateTime date, Post post) {
        this.user = user;
        this.content = content;
        this.attachment = attachment;
        this.date = date;
        this.post =post;
    }
}


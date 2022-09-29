package com.go4code.server.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    private String content;

    private String attachment;

    private int rating;

    private int viewers;

    private LocalDateTime date;

    public Post(){}

    public Post(Long id, User user,LocalDateTime date, List<Comment> comments, String content, String attachment, int rating, int viewers) {
        this.id = id;
        this.user = user;
        this.comments = comments;
        this.content = content;
        this.attachment = attachment;
        this.rating = rating;
        this.date = date;
        this.viewers = viewers;
    }

    public Post( User user, List<Comment> comments,LocalDateTime date, String content, String attachment, int rating, int viewers) {
        this.user = user;
        this.comments = comments;
        this.content = content;
        this.attachment = attachment;
        this.rating = rating;
        this.date = date;
        this.viewers = viewers;
    }
}

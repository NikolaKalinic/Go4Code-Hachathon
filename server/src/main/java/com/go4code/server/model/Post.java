package com.go4code.server.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getViewers() {
		return viewers;
	}

	public void setViewers(int viewers) {
		this.viewers = viewers;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
    
    
}

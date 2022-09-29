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
    
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    private String content;

    private String attachment;

    @ManyToOne(fetch = FetchType.EAGER)
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
    
    
}


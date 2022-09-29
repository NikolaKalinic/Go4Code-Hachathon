package com.go4code.server.dto;

import java.time.LocalDateTime;

import javax.persistence.ManyToOne;

import com.go4code.server.model.Comment;
import com.go4code.server.model.Post;
import com.go4code.server.model.User;

public class CommentDTO {
	
	private Long id;
    private User user;

    private String content;

    private String attachment;

    private Post post;

    private LocalDateTime date;


    public CommentDTO(){

    }

    public CommentDTO(Long id, User user, String content, String attachment,LocalDateTime date, Post post) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.date = date;
        this.attachment = attachment;
        this.post = post;
    }

    public CommentDTO( User user, String content, String attachment, LocalDateTime date, Post post) {
        this.user = user;
        this.content = content;
        this.attachment = attachment;
        this.date = date;
        this.post =post;
    }
    
    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.user = comment.getUser();
        this.content = comment.getContent();
        this.date = comment.getDate();
        this.attachment = comment.getAttachment();
        this.post = comment.getPost();
    }

	public CommentDTO(User user, String content, LocalDateTime date, Post post) {
		this.user = user;
		this.content = content;
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

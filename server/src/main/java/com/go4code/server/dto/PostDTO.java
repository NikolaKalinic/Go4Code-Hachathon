package com.go4code.server.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.go4code.server.model.Comment;
import com.go4code.server.model.Post;
import com.go4code.server.model.User;

public class PostDTO {
	
	    private Long id;
	    
	    private User user;

	    private List<Comment> comments;

	    private String content;

	    private String attachment;

	    private int rating;

		private int viewers;

	    private LocalDateTime date;
	    
	    public PostDTO(){}

	    public PostDTO(Long id, User user,LocalDateTime date, List<Comment> comments, String content, String attachment, int rating, int viewers) {
	        this.id = id;
	        this.user = user;
	        this.comments = comments;
	        this.content = content;
	        this.attachment = attachment;
	        this.rating = rating;
	        this.date = date;
	        this.viewers = viewers;
	    }

	    public PostDTO( User user, List<Comment> comments,LocalDateTime date, String content, String attachment, int rating, int viewers) {
	        this.user = user;
	        this.comments = comments;
	        this.content = content;
	        this.attachment = attachment;
	        this.rating = rating;
	        this.date = date;
	        this.viewers = viewers;
	    }
	    
	    public PostDTO( Post post) {
	    	this.id = post.getId();
	        this.user = post.getUser();
	        this.comments = post.getComments();
	        this.content = post.getContent();
	        this.attachment = post.getAttachment();
	        this.rating = post.getRating();
	        this.date = post.getDate();
	        this.viewers = post.getViewers();
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

		@Override
		public String toString() {
			return "PostDTO [id=" + id + ", user=" + user + ", comments=" + comments + ", content=" + content
					+ ", attachment=" + attachment + ", rating=" + rating + ", viewers=" + viewers + ", date=" + date
					+ "]";
		}

	}

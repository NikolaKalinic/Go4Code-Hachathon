package com.go4code.server.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.go4code.server.dto.CommentDTO;
import com.go4code.server.model.Comment;
import com.go4code.server.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.go4code.server.dto.PostDTO;
import com.go4code.server.model.Post;
import com.go4code.server.service.PostService;

@RestController
@CrossOrigin("http://localhost:4200")
public class PostController {
	
	@Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @GetMapping(value = "api/posts")
    public ResponseEntity getPostsPage() {
        final List<PostDTO> retVal = postService.findAllByDate().stream()
                .map(PostDTO::new)
                .collect(Collectors.toList());

        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }
    
    @GetMapping(value = "api/getLatestPost")
    public ResponseEntity getLatestPost() {
        final Post retVal = postService.findAllByDate().get(0);

        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }
    
    @GetMapping(value = "api/posts/{id}")
    public ResponseEntity getPost(@PathVariable Long id) {
        final Post post = postService.findOne(id);

        if (post == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        final PostDTO postDTO = new PostDTO(post);
        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }
    
    @PostMapping(value = "api/posts")
    public ResponseEntity create(@RequestBody PostDTO postDTO) {
        final Post post = new Post();
        post.setUser(postDTO.getUser());
        post.setComments(postDTO.getComments());
        post.setDate(postDTO.getDate());
        post.setContent(postDTO.getContent());
        post.setAttachment(postDTO.getAttachment());
        post.setRating(postDTO.getRating());
        post.setViewers(postDTO.getViewers());

        final Post savedPost = postService.save(post);
        List<Post> retVal = postService.findAllByDate();
        return new ResponseEntity<>(retVal, HttpStatus.CREATED);
    }

    @PutMapping(value = "api/posts/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody PostDTO postDTO) {
        final Post post = postService.findOne(id);

        if (post == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        post.setId(id);
        post.setUser(postDTO.getUser());
        post.setComments(postDTO.getComments());
        post.setDate(postDTO.getDate());
        post.setContent(postDTO.getContent());
        post.setAttachment(postDTO.getAttachment());
        post.setRating(postDTO.getRating());
        post.setViewers(postDTO.getViewers());

        final Post savedPost = postService.save(post);
        List<Post> retVal = postService.findAllByDate();
        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }

    @DeleteMapping(value = "api/posts/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        final Post post = postService.findOne(id);
        if (post == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        postService.remove(id);
        
        List<Post> retVal = postService.findAllByDate();
        return new ResponseEntity(retVal,HttpStatus.OK);
    }

    @GetMapping(value = "api/post/{id}/comments")
    public ResponseEntity getComments(@PathVariable Long id) {
        final List<Comment> comments = commentService.findCommentsByPostId(id);

//        if (comments == null) {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//
//        final List<CommentDTO> commentDTO = new CommentDTO();



        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

}

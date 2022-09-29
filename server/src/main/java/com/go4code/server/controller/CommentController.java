package com.go4code.server.controller;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

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

import com.go4code.server.dto.CommentDTO;
import com.go4code.server.model.Comment;
import com.go4code.server.service.CommentService;

@RestController
@CrossOrigin("http://localhost:4200")
public class CommentController {
	
	@Autowired
    CommentService commentService;

    @GetMapping(value = "api/comments")
    public ResponseEntity getCommentsPage() {
        final List<CommentDTO> retVal = commentService.findAll().stream()
                .map(CommentDTO::new)
                .collect(Collectors.toList());

        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }
    
    @GetMapping(value = "api/comments/{id}")
    public ResponseEntity getComment(@PathVariable Long id) {
        final Comment comment = commentService.findOne(id);

        if (comment == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        final CommentDTO commentDTO = new CommentDTO(comment);
        return new ResponseEntity<>(commentDTO, HttpStatus.OK);
    }
    
    @PostMapping(value = "api/comments")
    public ResponseEntity create(@RequestBody CommentDTO commentDTO) {
        final Comment comment = new Comment();
        comment.setUser(commentDTO.getUser());
        comment.setContent(commentDTO.getContent());
        comment.setPost(commentDTO.getPost());
        comment.setDate(LocalDateTime.now());
        final Comment savedComment = commentService.save(comment);
        return new ResponseEntity<>(new CommentDTO(savedComment), HttpStatus.CREATED);
    }

    @PutMapping(value = "api/comments/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody CommentDTO commentDTO) {
        final Comment comment = commentService.findOne(id);

        if (comment == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        comment.setId(id);
        comment.setUser(commentDTO.getUser());
        comment.setContent(commentDTO.getContent());
        comment.setPost(commentDTO.getPost());

        final Comment savedComment = commentService.save(comment);
        return new ResponseEntity<>(new CommentDTO(savedComment), HttpStatus.OK);
    }

    @DeleteMapping(value = "api/comments/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        final Comment comment = commentService.findOne(id);
        if (comment == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        commentService.remove(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}

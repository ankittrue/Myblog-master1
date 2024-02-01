package com.myblog.controller;

import com.myblog.entity.Comment;
import com.myblog.payload.CommentDto;
import com.myblog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //    http://localhost:8080/api/comments?post_id=1
    @PostMapping
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto,
            @RequestParam long post_id) {
        CommentDto dto = commentService.createComment(commentDto, post_id);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
// http://localhost:8080/api/comments/2
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>("Comment is deleted !!", HttpStatus.OK);
    }

    @PutMapping("/{id}/post/{postId}")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable long id,
            @RequestBody CommentDto CommentDto, @PathVariable long postId) {
        CommentDto dto = commentService.updateComment(id, CommentDto, postId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


}
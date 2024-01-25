package com.myblog.controller;

import com.myblog.payload.CommentDto;
import com.myblog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private CommentService commentService;
    public CommentController(CommentService commentService){
        this.commentService=commentService;
    }

//    http://localhost:8080/api/comments?post_id=1
    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @RequestParam long post_id){
       CommentDto dto = commentService.createComment(commentDto,post_id);
       return  new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}

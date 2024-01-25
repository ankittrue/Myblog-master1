package com.myblog.service.serviceimpl;

import com.myblog.controller.CommentController;
import com.myblog.entity.Comment;
import com.myblog.entity.Post;
import com.myblog.exception.ResourceNotFoundException;
import com.myblog.payload.CommentDto;
import com.myblog.repository.CommentRepository;
import com.myblog.repository.PostRepository;
import com.myblog.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentServiceImpl(PostRepository postRepository,CommentRepository commentRepository){
        this.postRepository=postRepository;
        this.commentRepository=commentRepository;
    }
    @Override
    public CommentDto createComment(CommentDto commentDto, long post_id) {
        Post post = postRepository.findById(post_id).orElseThrow(
                () -> new ResourceNotFoundException("Post Not Found Exception with Id: " + post_id)
        );
        Comment comment = new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);

        Comment savedComment = commentRepository.save(comment);

        CommentDto dtos = new CommentDto();

        dtos.setId(savedComment.getId());
        dtos.setEmail(savedComment.getEmail());
        dtos.setEmail(savedComment.getEmail());


        return dtos;
    }
}

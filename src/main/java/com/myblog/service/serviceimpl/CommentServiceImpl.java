package com.myblog.service.serviceimpl;

import com.myblog.entity.Comment;
import com.myblog.entity.Post;
import com.myblog.exception.ResourceNotFoundException;
import com.myblog.payload.CommentDto;
import com.myblog.repository.CommentRepository;
import com.myblog.repository.PostRepository;
import com.myblog.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
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

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }


    @Override
    public CommentDto updateComment(long id, CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post Not Found Exception with Id: " + id));
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment Not Found Exception with Id: " + id));

        Comment c = mapToEntity(commentDto);
        c.setId(comment.getId());
        c.setPost(post);
        Comment savedComment = commentRepository.save(c);
        return mapToDto(savedComment);
    }



    CommentDto mapToDto(Comment comment) {
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
        return dto;
    }
    Comment mapToEntity(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return comment;
    }

}

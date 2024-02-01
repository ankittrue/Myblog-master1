package com.myblog.service;

import com.myblog.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, long post_id);

    void deleteComment(long id);

    CommentDto updateComment(long id, CommentDto commentDto, long postId);
}

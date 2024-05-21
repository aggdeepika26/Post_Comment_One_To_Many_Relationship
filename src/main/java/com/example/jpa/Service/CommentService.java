package com.example.jpa.Service;

import com.example.jpa.model.Comment;
import com.example.jpa.model.Post;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComment();
    public void addCommentToPost(Long postId, Comment comment);
    void saveComment(Comment comment);
    Comment getCommentById(Long id);
    void deleteCommentById(Long id);
}

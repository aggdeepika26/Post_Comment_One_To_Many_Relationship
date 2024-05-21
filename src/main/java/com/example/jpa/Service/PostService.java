package com.example.jpa.Service;

import com.example.jpa.model.Post;

import java.util.List;

public interface PostService
{
    List<Post> getAllPost();
    void savePost(Post post);
    Post getPostById(Long id);
    void deletePostById(Long id);
}

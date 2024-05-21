package com.example.jpa.Service;

import com.example.jpa.model.Post;
import com.example.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostServiceImpl implements PostService{


    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository)
    {
        this.postRepository= postRepository;
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }
    @Override
    public void savePost(Post post)

    {
        this.postRepository.save(post);

    }
    @Override
    public Post getPostById(Long id)
    {
        Optional<Post> postOptional = this.postRepository.findById(id);
        Post post = null;
        if(postOptional.isPresent())
        {
            post = postOptional.get();

        }
        else
        {
            throw new RuntimeException("Post not found " + id);
        }
        return post;

    }

    public void deletePostById(Long id)
    {
        this.postRepository.deleteById(id);
    }

}

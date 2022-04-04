package com.abi.openfeign.service;

import com.abi.openfeign.client.PostClient;
import com.abi.openfeign.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    // Inject Feign client
    @Autowired
    private PostClient postClient;

    @Override
    public List<Post> getPost() {
        return postClient.getPosts();
    }

    @Override
    public Post getPostById(Integer id) {
        return postClient.getPostById(id);
    }

    @Override
    public List<Post> getPostByUserId(Integer userId) {
        return postClient.getPostByUserId(userId);
    }

}

package com.abi.openfeign.service;

import com.abi.openfeign.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getPost();
    Post getPostById(Integer postId);
    List<Post> getPostByUserId(Integer userId);
}

package com.abi.openfeign.controller;

import com.abi.openfeign.model.Post;
import com.abi.openfeign.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post-client")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/read")
    public ResponseEntity<List<Post>> read() {
        List<Post> postList = postService.getPost();
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping("/read/{postId}")
    public ResponseEntity<Post> read(@PathVariable("postId") Integer postId) {
        Post postById = postService.getPostById(postId);
        return new ResponseEntity<>(postById, HttpStatus.OK);
    }

    @GetMapping("/read/user")
    public ResponseEntity<List<Post>> readUserPosts(@RequestParam(name = "userId") Integer userId) {
        List<Post> postByUserId = postService.getPostByUserId(userId);
        return new ResponseEntity<>(postByUserId, HttpStatus.OK);
    }
}

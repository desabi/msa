package com.abi.openfeign.client;

import com.abi.openfeign.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com")
public interface PostClient {

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<Post> getPosts();

    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}")
    Post getPostById(@PathVariable("postId") Integer postId);

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<Post> getPostByUserId(@RequestParam(name = "userId") Integer userId);
}

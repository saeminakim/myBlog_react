package com.lilykim.myblog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class PostController {

    @Autowired PostService postService;

    @GetMapping(value = "/posts")
    public List<Post> getPosts() throws ExecutionException, InterruptedException {
        return postService.getPosts();
    }

    @PostMapping(value = "/createPost")
    public void createPost(@RequestBody Post post) throws ExecutionException, InterruptedException {
        postService.createPost(post);
    }
}

package com.lilykim.myblog.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class PostController {

    @Autowired PostService postService;

    @GetMapping("hello")
    public List<String> hello() {
        return Arrays.asList("hello", "world");
    }

    @GetMapping("posts")
    public List<Post> getPosts() throws ExecutionException, InterruptedException {
        return postService.getPosts();
    }
}

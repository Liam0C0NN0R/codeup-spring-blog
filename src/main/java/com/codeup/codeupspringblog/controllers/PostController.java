package com.codeup.codeupspringblog.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @GetMapping("/posts")
    public String postsIndex() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable int id) {
        return "View an individual post with id: " + id;
    }

    @GetMapping("/posts/create")
    public String viewCreatePostForm() {
        return "View the form for creating a post";
    }

    @PostMapping("/posts/create")
    public String createPost() {
        return "Create a new post";
    }
}


package com.codeup.codeupspringblog.controllers;

import models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts/create")
    public String viewCreatePostForm() {
        return "View the form for creating a post";
    }

    @PostMapping("/posts/create")
    public String createPost() {
        return "Create a new post";
    }
    @GetMapping("/posts")
    public String postsIndex(Model model) {
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post();
        post1.setTitle("Title 1");
        post1.setBody("Body 1");

        Post post2 = new Post();
        post2.setTitle("Title 2");
        post2.setBody("Body 2");

        posts.add(post1);
        posts.add(post2);

        model.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable int id, Model model) {
        Post post = new Post();
        post.setTitle("Title " + id);
        post.setBody("Body " + id);

        model.addAttribute("post", post);

        return "posts/show";
    }

}


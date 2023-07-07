package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.codeup.codeupspringblog.repositories.PostRepository;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepo;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/posts/create")
    public String viewCreatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        User user = userRepository.findFirstByOrderByIdAsc();
        if(user != null){
            post.setUser(user);
        } else {
            // handle the case where no user was found, e.g. redirect to an error page
            return "redirect:/error";
        }
        postRepo.save(post);
        return "redirect:/posts";
    }


    @GetMapping("/posts")
    public String postsIndex(Model model) {
        model.addAttribute("posts", postRepo.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        postRepo.findById(id).ifPresent(post -> model.addAttribute("post", post));
        return "posts/show";
    }
}

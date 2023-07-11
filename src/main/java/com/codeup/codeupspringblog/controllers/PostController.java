package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.models.EmailService;
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
    @Autowired
    private EmailService emailService;  // inject EmailService

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
        emailService.prepareAndSend(post, "New post created", "A new post has been created with title: " + post.getTitle());  // send email
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
    @GetMapping("/posts/{id}/edit")
    public String viewEditPostForm(@PathVariable Long id, Model model) {
        Post post = postRepo.findById(id).orElse(null);
        if (post == null) {
            // handle the case where no post was found, e.g. redirect to an error page
            return "redirect:/error";
        }
        model.addAttribute("post", post);
        return "posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable Long id, @ModelAttribute Post updatedPost) {
        Post post = postRepo.findById(id).orElse(null);
        if (post == null) {
            // handle the case where no post was found, e.g. redirect to an error page
            return "redirect:/error";
        }
        updatedPost.setId(post.getId()); // Ensure the id is preserved
        updatedPost.setUser(post.getUser()); // Ensure the user is preserved
        postRepo.save(updatedPost);
        return "redirect:/posts/" + id;
    }

}

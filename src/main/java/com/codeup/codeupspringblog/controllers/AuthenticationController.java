package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthenticationController {
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }

//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password) {
//        // Handle login authentication here using the passwordEncoder
//        // and any user authentication service you have.
//        // The implementation depends on your application structure.
//
//        // For now, redirect to the home page
//        return "redirect:/";
//    }

//    @GetMapping("/sign-up")
//    public String showSignUpForm(Model model) {
//        // You may want to pass a new User object to the sign-up view to capture sign-up details.
//
//        // For now, return the sign up view
//        return "users/sign-up";
//    }
//
//    @PostMapping("/sign-up")
//    public String signUp(@ModelAttribute User user) {
//        // You would save the user details here, making sure to encode the password.
//        String hashedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hashedPassword);
//        // Save the user using your UserRepository
//
//        // Redirect to login page after successful sign-up
//        return "redirect:/login";
//    }
}

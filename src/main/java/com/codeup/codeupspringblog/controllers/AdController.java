package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.EmailService;
import org.springframework.stereotype.Controller;

@Controller
class AdController {
    // ...
    private final EmailService emailService;

    public AdController(EmailService emailService) {
        this.emailService = emailService;
    }
    // ...
}


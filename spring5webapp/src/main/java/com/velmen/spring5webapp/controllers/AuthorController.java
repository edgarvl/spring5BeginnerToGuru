package com.velmen.spring5webapp.controllers;

import com.velmen.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/Authors")
    public String getAuthors(Model model){
        model.addAttribute("authors",authorRepository.findAll());

        return "authors";
    }
}

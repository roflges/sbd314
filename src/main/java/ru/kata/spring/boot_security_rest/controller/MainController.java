package ru.kata.spring.boot_security_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security_rest.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/main")
public class MainController {
    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showMainPage(Model model, Principal principal) {
        model.addAttribute("authorizedUser", userService.getUserByUsername(principal.getName()));
        return "main";
    }
}
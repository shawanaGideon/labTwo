package com.example.labTwo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("message", "Welcome to COMP367");
        return "welcome";
    }

    @GetMapping("/greeting")
    public String greeting(Model model) {
        LocalTime currentTime = LocalTime.now();
        String greetingMessage;

        if (currentTime.isBefore(LocalTime.NOON)) {
            greetingMessage = "Good morning, Gideon, Welcome to COMP367";
        } else if (currentTime.isBefore(LocalTime.of(18, 0))) {
            greetingMessage = "Good afternoon, Gideon, Welcome to COMP367";
        } else {
            greetingMessage = "Good evening, Gideon, Welcome to COMP367";
        }

        model.addAttribute("message", greetingMessage);
        return "welcome";
    }
}

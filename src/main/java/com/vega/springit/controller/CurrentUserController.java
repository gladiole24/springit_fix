package com.vega.springit.controller;

import com.vega.springit.domain.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class CurrentUserController {

    @ModelAttribute("currentUser")
    public String getCurrentUser(Model model) {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("user", user);
            return "";
        }

        model.addAttribute("user", new User()); // create a empty user
        return "";
    }
}

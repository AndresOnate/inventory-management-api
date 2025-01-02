package com.org.inventory.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class to handle the user-facing views related to the home and login pages.
 * 
 * This controller is responsible for managing requests to the login and home pages. It fetches the authenticated user's 
 * details and renders the appropriate views, allowing users to interact with the application post-login.
 */
@Controller
public class HomeController {

    /**
     * Handles requests to the "/home" URL.
     * @param principal The OAuth2User object that represents the authenticated user.
     * @param model The model used to pass data to the view.
     * @return The name of the view to be rendered (home.html).
     */
    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OAuth2User principal, Model model) {
        model.addAttribute("name", principal.getAttribute("name"));
        return "home";
    }

    /**
     * Handles requests to the "/login" URL.
     * @return The name of the view to be rendered (login.html).
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
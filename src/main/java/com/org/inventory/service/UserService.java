package com.org.inventory.service;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.org.inventory.model.User;

/**
 * Service class for managing user-related operations.
 * This class provides functionality to handle the creation of user entities
 * from the information provided by the OAuth2 login process.
 */
@Service
public class UserService {
    public User createUser(OAuth2User oAuth2User) {
        User user = new User();
        user.setName(oAuth2User.getAttribute("name"));
        user.setEmail(oAuth2User.getAttribute("email"));
        return user;
    }
}
package com.app.muamalat.services;

import com.app.muamalat.entities.User;
import com.app.muamalat.exceptions.UserNotFoundException;
import com.app.muamalat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User isUserExist(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }
}

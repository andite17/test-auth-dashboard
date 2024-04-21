package com.app.muamalat.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {
        super("User not found with email: " + email);
    }

}

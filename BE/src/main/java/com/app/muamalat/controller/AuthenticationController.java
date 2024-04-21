package com.app.muamalat.controller;

import com.app.muamalat.dto.LoginDto;
import com.app.muamalat.dto.LoginResponseDto;
import com.app.muamalat.dto.RegisterDto;
import com.app.muamalat.entities.User;
import com.app.muamalat.services.AuthenticationService;
import com.app.muamalat.services.JwtService;
import com.app.muamalat.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/auth")
public class AuthenticationController {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(@Valid @RequestBody LoginDto data) {
        userService.isUserExist(data.getEmail());

        User authenticatedUser = authenticationService.authenticate(data);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponseDto loginResponse = new LoginResponseDto();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }


}

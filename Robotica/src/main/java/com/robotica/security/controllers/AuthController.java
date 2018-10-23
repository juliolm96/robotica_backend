package com.robotica.security.controllers;

import com.robotica.payload.ApiResponse;
import com.robotica.payload.JwtAuthenticationResponse;
import com.robotica.payload.LoginRequest;
import com.robotica.payload.SignUpRequest;
import com.robotica.security.JwtTokenProvider;
import com.robotica.security.dao.JDBCUser;
import com.robotica.security.models.User;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JDBCUser userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    	
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        
        String role = tokenProvider.generateRole(authentication);
        
        return new ResponseEntity<>(new JwtAuthenticationResponse(jwt, role), HttpStatus.ACCEPTED);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
    	
        if(userRepository.usernameExist(signUpRequest.getUsername())) {
            return new ResponseEntity<>(new ApiResponse(false, "El nombre de usuario ya ha sido utilizado"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.emailExist(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ApiResponse(false, "El email actualmente está en uso"),
                    HttpStatus.BAD_REQUEST);
        }

        // Crear la cuenta de usuario
        User user = new User(signUpRequest.getUsername(),signUpRequest.getEmail(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        try {
        	userRepository.create(user);
        } catch(Exception e) {
        	logger.error(e.getMessage());
        	return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }
    
}

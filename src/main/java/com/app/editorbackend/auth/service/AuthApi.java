package com.app.editorbackend.auth.service;

import com.app.editorbackend.user.service.Role;
import com.app.editorbackend.user.service.User;
import com.app.editorbackend.user.service.UserRepo;
import com.app.editorbackend.user.service.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashSet;


@RestController
@RequestMapping(path = "api/public")
@RequiredArgsConstructor
public class AuthApi {
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final JwtTokenUtil jwtTokenUtil;
    @Autowired
    UserRepo userRepo;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserRequest request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            User user = (User) authenticate.getPrincipal();

            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.generateAccessToken(user))
                    .body(user);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("register")
    public User register(@RequestBody User request) {
        request.setEnabled(true);
        request.setAccountNonLocked(true);
        request.setAccountNonExpired(true);
        HashSet set = new HashSet();
        set.add(Role.USER_ADMIN);
//        request.setAuthorities(set);
        request.setCredentialsNonExpired(true);
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepo.save(request);
    }

}
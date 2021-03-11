package com.app.editorbackend.user;

import com.app.editorbackend.user.service.User;
import com.app.editorbackend.user.service.UserRepo;
import com.app.editorbackend.user.service.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepo userRepository;

    @GetMapping("/get")
    public List<User> getAllUser() {
        return userRepository.findAll();

    }

//    @GetMapping("/login")
//    public void login() {
//        return;
//    }
//
//    @Transactional
//    @PostMapping("/register")
//    public ResponseEntity userRegistration(@RequestBody User user) {
//        if (userExist(user.getUsername())) {
//            return new ResponseEntity("There is an account with that email address: " + user.getUsername(), HttpStatus.BAD_REQUEST);
//        }
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        user.setEnabled(true);
//        user.setRoles("USER");
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//        userRepository.save(user);
//        return null;
//    }

//    private boolean userExist(String username) {
//        return userRepository.findByUsername(username).isPresent();
//    }
}

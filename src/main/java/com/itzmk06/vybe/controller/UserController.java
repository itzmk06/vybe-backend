package com.itzmk06.vybe.controller;

import com.itzmk06.vybe.model.User;
import com.itzmk06.vybe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody User user) {
        userService.saveStudent(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("New user is added");
    }

    @GetMapping("/getAll")
    public List<User> getAllStudents() {
        return userService.getAllStudents();
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        String signUpResult = userService.signUpStudent(user);
        if ("Email already exists".equals(signUpResult)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(signUpResult);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(signUpResult);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User existingUser = userService.getStudentByEmail(user.getUserMail());

        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }

        if (!existingUser.getUserPassword().equals(user.getUserPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong password");
        }

        return ResponseEntity.ok("Login successful!");
    }
}

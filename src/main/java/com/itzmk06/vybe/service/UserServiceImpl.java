package com.itzmk06.vybe.service;

import com.itzmk06.vybe.model.User;
import com.itzmk06.vybe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveStudent(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllStudents() {
        return userRepository.findAll();
    }

    @Override
    public User getStudentByEmail(String userMail) {
        return userRepository.findByUserMail(userMail);
    }

    @Override
    public boolean existsByEmail(String userMail) {
        return userRepository.existsByUserMail(userMail);
    }

    @Override
    public String signUpStudent(User user) {
        if (userRepository.existsByUserMail(user.getUserMail())) {
            return "Email already exists";
        }
        userRepository.save(user);
        return "User registered successfully!";
    }
}

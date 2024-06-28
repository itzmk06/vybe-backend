package com.itzmk06.vybe.service;

import com.itzmk06.vybe.model.User;

import java.util.List;

public interface UserService {
    User saveStudent(User user);
    List<User> getAllStudents();
    User getStudentByEmail(String userMail);
    boolean existsByEmail(String userMail);
    String signUpStudent(User user);
}

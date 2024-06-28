package com.itzmk06.vybe.repository;

import com.itzmk06.vybe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserMail(String userMail);
    boolean existsByUserMail(String userMail);
}

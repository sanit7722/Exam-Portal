package com.exam.services;

import com.exam.entities.User;
import com.exam.entities.UserRole;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    public User findByUsername(String userName);


    void deleteUser(Long userId);

    List<User> getAllUsers();
    User updateUser(Long userId, User user) throws Exception;
}

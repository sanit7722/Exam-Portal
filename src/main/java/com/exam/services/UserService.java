package com.exam.services;

import com.exam.entities.User;
import com.exam.entities.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
}

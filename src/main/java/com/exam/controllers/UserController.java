package com.exam.controllers;

import com.exam.entities.Role;
import com.exam.entities.User;
import com.exam.entities.UserRole;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping( "/user")
public class UserController {

    @Autowired
    private UserService userService;

    //create user
    @PostMapping( "/")
    public ResponseEntity createUser(@RequestBody User user) throws Exception {


        Set<UserRole> roles=new HashSet<>();
        Role role=new Role();
        role.setRoleId(44);
        role.setRoleName("MORMAL");
        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        userService.createUser(user, roles);
        return new ResponseEntity(user, HttpStatus.OK);
    }



}

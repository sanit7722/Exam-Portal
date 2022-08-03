package com.exam.controllers;

import com.exam.entities.Role;
import com.exam.entities.User;
import com.exam.entities.UserRole;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
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
        return new ResponseEntity(user, HttpStatus.CREATED);
    }


    @GetMapping("/{username}")
    public ResponseEntity getUserByUsername(@PathVariable("username") String username){
        User savedUser = userService.findByUsername(username);
        return new ResponseEntity(savedUser,HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity getAllUser(){
        List<User> allUsers = this.userService.getAllUsers();
        return new ResponseEntity(allUsers,HttpStatus.OK);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("{userId}")
    public ResponseEntity updateUser(@PathVariable Long userId, @RequestBody User user) throws Exception {

        User updatedUser = this.userService.updateUser(userId, user);
        return new ResponseEntity(updatedUser,HttpStatus.OK);

    }


}

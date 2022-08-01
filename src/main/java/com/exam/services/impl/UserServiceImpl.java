package com.exam.services.impl;

import com.exam.entities.User;
import com.exam.entities.UserRole;
import com.exam.repositories.RoleRepo;
import com.exam.repositories.UserRepo;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local=this.userRepo.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("user already exists");
            throw new Exception("User already exists");
        }else {
            //create user
            for(UserRole ur:userRoles){
                roleRepo.save(ur.getRole());
            }
            user.getUseRoles().addAll(userRoles);
            local=this.userRepo.save(user);





        }
        return local;
    }
}

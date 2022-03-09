package com.example.users.service;

import com.example.users.model.MyUser;
import com.example.users.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<MyUser> getUsers() {
        List<MyUser> userList=userRepository.findAll();
        return userList;
    }

    public void addUser(MyUser myUser) {
      userRepository.save(myUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public void updateUser(Integer id,MyUser myUser) {
       MyUser updateUser=userRepository.getById(id);
       updateUser.setUsername(myUser.getUsername());
       updateUser.setEmail(myUser.getEmail());
       updateUser.setPassword(myUser.getPassword());
       updateUser.setRole(myUser.getRole());
       userRepository.save(updateUser);

    }
}

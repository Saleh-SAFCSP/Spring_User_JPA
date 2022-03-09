package com.example.users.controller;

import com.example.users.model.MyUser;
import com.example.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {


    private  UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("user")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping("user")
    public ResponseEntity addUser(@RequestBody MyUser myUser){
        userService.addUser(myUser);
        return ResponseEntity.status(201).body("User added !");
    }

    @PutMapping("user/{id}")
    public ResponseEntity updateUser(@RequestBody MyUser myUser,@PathVariable Integer id){
        userService.updateUser(id,myUser);
        return ResponseEntity.status(200).body("User updated !");
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("User deleted !");
    }

}

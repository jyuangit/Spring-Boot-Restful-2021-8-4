package com.example.SpringBootRestful.controller;

import com.example.SpringBootRestful.entity.CreateUser;
import com.example.SpringBootRestful.entity.User;
import com.example.SpringBootRestful.exception.BusinessException;
import com.example.SpringBootRestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
//ToDo:在上一行代码("")中填写合适的RestfulApi
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity addUser(@RequestBody CreateUser createUser) {

        userService.addUser(CreateUser.toEmployee(createUser));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity updateUserById(@PathVariable Integer userId, @RequestBody User user) throws BusinessException {
        userService.updateUserById(userId, user);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{userId}")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity deleteUserById(@PathVariable Integer userId) throws BusinessException {
        userService.deleteUserById(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

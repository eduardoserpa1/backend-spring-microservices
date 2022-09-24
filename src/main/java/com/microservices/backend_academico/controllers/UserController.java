package com.microservices.backend_academico.controllers;

import com.microservices.backend_academico.dtos.DisciplinaDTO;
import com.microservices.backend_academico.dtos.UserDTO;
import com.microservices.backend_academico.models.DisciplinaModel;
import com.microservices.backend_academico.models.UserModel;
import com.microservices.backend_academico.services.UserService;
import com.microservices.backend_academico.session.UserSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserSession userSession;


    @PostMapping("/create")
    public ResponseEntity<UserModel> create(@RequestBody UserDTO userDTO){
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDTO, userModel);
        return new ResponseEntity<>(userService.create(userModel), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(String username, String password){
        return new ResponseEntity<>(userService.login(username,password), HttpStatus.CREATED);
    }

    @PostMapping("/logout")
    public ResponseEntity<Boolean> logout(){
        return new ResponseEntity<>(userService.logout(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Boolean> status(){
        return new ResponseEntity<>( userSession.getAuth(), HttpStatus.OK);
    }

}

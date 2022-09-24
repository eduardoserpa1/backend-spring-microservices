package com.microservices.backend_academico.controllers;

import com.microservices.backend_academico.dtos.DisciplinaDTO;
import com.microservices.backend_academico.dtos.UserDTO;
import com.microservices.backend_academico.models.DisciplinaModel;
import com.microservices.backend_academico.models.UserModel;
import com.microservices.backend_academico.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/create")
    public ResponseEntity<UserModel> cadastraDisciplina(@RequestBody UserDTO userDTO){
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDTO, userModel);
        return new ResponseEntity<>(userService.create(userModel), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> cadastraDisciplina(String username, String password){
        return new ResponseEntity<>(userService.login(username,password), HttpStatus.CREATED);
    }

    @PostMapping("/logout")
    public ResponseEntity<Boolean> cadastraDisciplina(){
        return new ResponseEntity<>(userService.logout(), HttpStatus.CREATED);
    }


}

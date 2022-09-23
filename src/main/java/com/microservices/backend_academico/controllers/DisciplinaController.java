package com.microservices.backend_academico.controllers;

import com.microservices.backend_academico.dtos.DisciplinaDTO;
import com.microservices.backend_academico.dtos.TurmaDTO;
import com.microservices.backend_academico.models.DisciplinaModel;
import com.microservices.backend_academico.models.TurmaModel;
import com.microservices.backend_academico.services.DisciplinaService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplina_service;

    @PostMapping("/create")
    public ResponseEntity<DisciplinaModel> cadastraTurma(@RequestBody DisciplinaDTO disciplinaDTO){
        DisciplinaModel disciplinaModel = new DisciplinaModel();
        BeanUtils.copyProperties(disciplinaDTO, disciplinaModel);
        disciplina_service.create(disciplinaModel);
        return new ResponseEntity<>(disciplinaModel, HttpStatus.CREATED);
    }

}

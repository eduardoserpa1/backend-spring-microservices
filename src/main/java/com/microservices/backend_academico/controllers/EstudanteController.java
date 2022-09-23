package com.microservices.backend_academico.controllers;

import com.microservices.backend_academico.dtos.EstudanteDTO;
import com.microservices.backend_academico.models.EstudanteModel;
import com.microservices.backend_academico.services.EstudanteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/estudante")
public class EstudanteController {

    @Autowired
    EstudanteService estudante_service;

    @GetMapping()
    public ResponseEntity<List<EstudanteModel>> find_all(){
        List<EstudanteModel> all_students = estudante_service.read_all();
        return new ResponseEntity<>(all_students, HttpStatus.FOUND);
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<List<EstudanteModel>> find_by_matricula(@PathVariable("matricula") String matricula){
        List<EstudanteModel> all_students = estudante_service.read_by_matricula(matricula);
        return new ResponseEntity<>(all_students, HttpStatus.FOUND);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<EstudanteModel>> find_by_nome(@PathVariable("nome") String nome){
        List<EstudanteModel> all_students = estudante_service.read_by_name(nome);
        return new ResponseEntity<>(all_students, HttpStatus.FOUND);
    }


    @PostMapping("/create")
    public ResponseEntity<EstudanteModel> cadastraEstudante(@RequestBody EstudanteDTO estudanteDto){
        EstudanteModel estudante = new EstudanteModel();
        BeanUtils.copyProperties(estudanteDto, estudante);
        estudante_service.create(estudante);
        return new ResponseEntity<>(estudante, HttpStatus.CREATED);
    }

    @PostMapping("/test")
    public String s(@RequestBody EstudanteDTO estudanteDto){
        return estudanteDto.getEndereco();
    }

}

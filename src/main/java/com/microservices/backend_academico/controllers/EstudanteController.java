package com.microservices.backend_academico.controllers;

import com.microservices.backend_academico.dtos.EstudanteDTO;
import com.microservices.backend_academico.models.EstudanteModel;
import com.microservices.backend_academico.services.EstudanteService;
import com.microservices.backend_academico.session.UserSession;
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

    @Autowired
    UserSession userSession;

    @GetMapping()
    public ResponseEntity<List<EstudanteModel>> find_all(){
        if(userSession.getAuth()){
            List<EstudanteModel> all_students = estudante_service.read_all();
            return new ResponseEntity<>(all_students, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.LOCKED);
        }

    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<List<EstudanteModel>> find_by_matricula(@PathVariable("matricula") String matricula){
        if (userSession.getAuth()){
            List<EstudanteModel> all_students = estudante_service.read_by_matricula(matricula);
            return new ResponseEntity<>(all_students, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.LOCKED);
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<EstudanteModel>> find_by_nome(@PathVariable("nome") String nome){
        if (userSession.getAuth()){
            List<EstudanteModel> all_students = estudante_service.read_by_name(nome);
            return new ResponseEntity<>(all_students, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.LOCKED);
        }

    }


    @PostMapping("/create")
    public ResponseEntity<EstudanteModel> cadastraEstudante(@RequestBody EstudanteDTO estudanteDto){
        if (userSession.getAuth()){
            EstudanteModel estudante = new EstudanteModel();
            BeanUtils.copyProperties(estudanteDto, estudante);
            estudante_service.create(estudante);
            return new ResponseEntity<>(estudante, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.LOCKED);
        }

    }

    @PostMapping("/test")
    public String s(@RequestBody EstudanteDTO estudanteDto){
        return estudanteDto.getEndereco();
    }

}

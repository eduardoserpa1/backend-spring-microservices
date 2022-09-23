package com.microservices.backend_academico.services;

import com.microservices.backend_academico.models.DisciplinaModel;
import com.microservices.backend_academico.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public DisciplinaModel create(DisciplinaModel disciplinaModel){
        return disciplinaRepository.save(disciplinaModel);
    }
}

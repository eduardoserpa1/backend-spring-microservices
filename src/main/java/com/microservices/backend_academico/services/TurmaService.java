package com.microservices.backend_academico.services;

import com.microservices.backend_academico.models.TurmaModel;
import com.microservices.backend_academico.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    public TurmaModel create(TurmaModel turmaModel){
        return turmaRepository.save(turmaModel);
    }
}

package com.microservices.backend_academico.services;


import com.microservices.backend_academico.exceptions.*;
import com.microservices.backend_academico.models.EstudanteModel;
import com.microservices.backend_academico.models.TurmaModel;
import com.microservices.backend_academico.repositories.EstudanteRepository;
import com.microservices.backend_academico.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;
    @Autowired
    EstudanteRepository estudanteRepository;

    public TurmaModel create(TurmaModel turmaModel) throws ReferenceDontExistsException{
        EstudanteModel estudanteModel = estudanteRepository.find_by_id(turmaModel.getId_estudante());

        if (estudanteModel != null)
            return turmaRepository.save(turmaModel);
        else
            throw new ReferenceDontExistsException();
    }
}

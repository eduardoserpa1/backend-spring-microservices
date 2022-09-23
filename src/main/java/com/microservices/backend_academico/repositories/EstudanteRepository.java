package com.microservices.backend_academico.repositories;

import com.microservices.backend_academico.models.EstudanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudanteRepository extends JpaRepository<EstudanteModel, Long> {


    @Query("SELECT x from EstudanteModel x where x.numero_matricula like ?1")
    EstudanteModel find_by_numero_matricula(String numero_matricula);
}

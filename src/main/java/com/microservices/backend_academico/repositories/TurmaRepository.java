package com.microservices.backend_academico.repositories;

import com.microservices.backend_academico.models.EstudanteModel;
import com.microservices.backend_academico.models.TurmaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaModel, Long> {

    @Query("SELECT x from TurmaModel x where x.id_turma = ?1")
    TurmaModel find_by_id_turma(Long id);
}

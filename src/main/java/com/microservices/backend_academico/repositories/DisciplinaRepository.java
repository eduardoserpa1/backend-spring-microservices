package com.microservices.backend_academico.repositories;

import com.microservices.backend_academico.models.DisciplinaModel;
import com.microservices.backend_academico.models.EstudanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<DisciplinaModel, Long> {

    @Query("SELECT x from DisciplinaModel x where x.id = ?1 and x.id_turma = ?2")
    DisciplinaModel find_by_ids(Long id_disciplina, Long id_turma);
}

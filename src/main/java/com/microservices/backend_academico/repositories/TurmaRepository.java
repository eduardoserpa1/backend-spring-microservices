package com.microservices.backend_academico.repositories;

import com.microservices.backend_academico.models.TurmaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaModel, Long> {
}
